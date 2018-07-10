package com.lime_it.infotector.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lime_it.infotector.model.Data;

public interface DataRepository extends CrudRepository<Data, Integer> {
    List<Data> findByDataColumns(String data_Columns);
    List<Data> findByFileId(String fileId);
}