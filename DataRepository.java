package com.io.project.dashboard.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.io.project.dashboard.model.Data;

public interface DataRepository extends JpaRepository<Data , Integer>{

    
}


