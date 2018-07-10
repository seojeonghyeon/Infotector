package com.lime_it.infotector.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lime_it.infotector.model.Data;

public interface DataRepository extends CrudRepository<Data, Integer> {
    List<Data> findByData_Columns(String data_Columns);
}