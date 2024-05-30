package com.io.project.dashboard.config;

import org.springframework.batch.item.ItemProcessor;

import com.io.project.dashboard.model.Data;

public class DataProcessor implements ItemProcessor<Data, Data> {
    @Override
	public Data process(Data item) throws Exception {

		// logic

		return item;
    }
}
