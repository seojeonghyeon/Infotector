package com.lime_it.infotector.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lime_it.infotector.model.User;
import com.lime_it.infotector.repo.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

   @Autowired
   UserRepository repository;

   static Logger logger = LoggerFactory.getLogger(UserController.class);

   @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<User>> getAll() {

      logger.debug("Calling getAll( )");

      List<User> list = new ArrayList<>();
      Iterable<User> users = repository.findAll();

      users.forEach(list::add);

      return new ResponseEntity<List<User>>(list, HttpStatus.OK);

   }

   @PostMapping(value = "/users")
   public ResponseEntity<Void> postCustomer(@RequestBody User user) {

      logger.debug("Calling postCustomer( )");

      int id = user.getId();
      String email = user.getUser_Email();
      String nick = user.getUser_Nick();
      String enable = user.getUser_Enable();
      
      repository.save(new User(id,email,nick,enable));

      return new ResponseEntity<Void>(HttpStatus.CREATED);
   }

   @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<User>> findByEmail(@PathVariable String email) {

      logger.debug("Calling findByEmail( )");

      List<User> users = repository.findByUser_Email(email);
      return new ResponseEntity<List<User>>(users, HttpStatus.OK);
   }

   @DeleteMapping(value = "users")
   public ResponseEntity<Void> deleteUser(@PathVariable int id) {

      logger.debug("Calling deleteUser( )");
      repository.deleteById( id);

      return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
   }

}