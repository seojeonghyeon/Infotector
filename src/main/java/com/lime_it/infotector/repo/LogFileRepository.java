package com.lime_it.infotector.repo;


import org.springframework.data.repository.CrudRepository;

import com.lime_it.infotector.model.LogFile;

public interface LogFileRepository extends CrudRepository<LogFile, Integer> {

}