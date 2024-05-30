package com.io.project.dashboard.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.io.project.dashboard.model.Data;
import com.io.project.dashboard.repo.DataRepository;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    private JobBuilderFactory jobBuilderFactory;
	private StepBuilderFactory stepBuilderFactory;
	private DataRepository dataRepository;

	@Bean
	public FlatFileItemReader<Data> dataReader() {
		FlatFileItemReader<Data> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/Data.csv"));
		itemReader.setName("csv-reader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}

	private LineMapper<Data> lineMapper() {

		DefaultLineMapper<Data> lineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("end_year","citylng","citylat","intensity","sector","topic","insight","swot","url","region","start_year","impact","added","published","city","country","relevance","pestle","source","title","likelihood");

		BeanWrapperFieldSetMapper<Data> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Data.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

	@Bean
	public DataProcessor dataProcessor() {
		return new DataProcessor();
	}

	@Bean
	public RepositoryItemWriter<Data> dataWriter() {

		RepositoryItemWriter<Data> writer = new RepositoryItemWriter<>();
		writer.setRepository(dataRepository);
		writer.setMethodName("save");

		return writer;
	}
	

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step-1").<Data, Data>chunk(10)
						  .reader(dataReader())
						  .processor(dataProcessor())
						  .writer(dataWriter())
						  .taskExecutor(taskExecutor())
						  .build();
	}
	
	
	@Bean
	public Job job() {
		return jobBuilderFactory.get("Data-import")
								.flow(step())
								.end()
								.build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}
	
	
}

