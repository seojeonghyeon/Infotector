package com.lime_it.infotector.repo;

import org.springframework.data.repository.CrudRepository;

import com.lime_it.infotector.model.LogData;

public interface LogDataRepository extends CrudRepository<LogData, Integer> {

}