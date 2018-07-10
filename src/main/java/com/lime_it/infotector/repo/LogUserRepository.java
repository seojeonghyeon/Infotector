package com.lime_it.infotector.repo;

import org.springframework.data.repository.CrudRepository;

import com.lime_it.infotector.model.LogUser;

public interface LogUserRepository extends CrudRepository<LogUser, Integer> {

}