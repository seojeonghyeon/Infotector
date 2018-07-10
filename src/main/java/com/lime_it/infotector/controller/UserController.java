package com.lime_it.infotector.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lime_it.infotector.repo.UserRepository;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	
}
