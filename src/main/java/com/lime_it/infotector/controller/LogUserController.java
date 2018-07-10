package com.lime_it.infotector.controller;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lime_it.infotector.model.LogUser;
import com.lime_it.infotector.repo.LogUserRepository;

@RestController
@RequestMapping("/api/loguser")
public class LogUserController {
   @Autowired
   LogUserRepository repository;

   static Logger logger = LoggerFactory.getLogger(LogUserController.class);

   //모든 로그 가져와서 전달
   @GetMapping(value = "/logusers", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<LogUser>> getLogUserAll() {
      logger.debug("Calling getAll( )");
      List<LogUser> list = new ArrayList<>();
      Iterable<LogUser> log_users = repository.findAll();
      log_users.forEach(list::add);
      return new ResponseEntity<List<LogUser>>(list, HttpStatus.OK);
   }

   //구현 완료
   //현재 시간과 서버 IP를 가져와서 저장.
   @PostMapping(value = "/logusers")
   public ResponseEntity<Void> postCustomer(@RequestBody LogUser loguser) {
	  //Current Time
	  SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
	  String current_time_str = time_formatter.format(System.currentTimeMillis());
	  
	  //Get IP
	  InetAddress local;
	  String ip="";
	  try {
	      local = InetAddress.getLocalHost();
	      ip = local.getHostAddress();
	  } catch (UnknownHostException e1) {
	      e1.printStackTrace();
	  }

      logger.debug("Calling postCustomer( )");
      String logTime = current_time_str;
      String logUserEmail = loguser.getLogUserEmail();
      String log_user_ip = ip;
      repository.save(new LogUser(logTime,logUserEmail,log_user_ip));
      return new ResponseEntity<Void>(HttpStatus.CREATED);
   }

}