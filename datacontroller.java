package com.io.project.dashboard.datacontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.project.dashboard.model.Data;
import com.io.project.dashboard.repo.DataRepository;


@RestController
@RequestMapping("/api/data")
public class datacontroller {
    @Autowired
    private DataRepository dataRepository;
    
    @GetMapping
    public List<Data> getAllData() {
        return (List<Data>) dataRepository.findAll();
    }

    @PostMapping
    public Data createdatapoint(@RequestBody Data data) {
        return dataRepository.save(data);
    }
}
