package com.lime_it.infotector.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.lime_it.infotector.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUser_Email(String user_Email);
}