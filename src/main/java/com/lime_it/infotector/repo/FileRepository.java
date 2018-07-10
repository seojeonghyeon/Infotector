package com.lime_it.infotector.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lime_it.infotector.model.File;

public interface FileRepository extends CrudRepository<File, Integer> {
    List<File> findByFile_Name(String file_Name);
    List<File> findByFiel_Id(String file_Id);
}