package com.lime_it.infotector.controller;

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

import com.lime_it.infotector.model.LogFile;
import com.lime_it.infotector.repo.LogFileRepository;

@RestController
@RequestMapping("/api/logfiles")
public class LogFileController {
   @Autowired
   LogFileRepository repository;

   static Logger logger = LoggerFactory.getLogger(LogFileController.class);

   @GetMapping(value = "/logfile", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<LogFile>> getLogFileAll() {
      logger.debug("Calling getAll( )");
      List<LogFile> list = new ArrayList<>();
      Iterable<LogFile> log_files = repository.findAll();
      log_files.forEach(list::add);
      return new ResponseEntity<List<LogFile>>(list, HttpStatus.OK);
   }

   @PostMapping(value = "/logfiles")
   public ResponseEntity<Void> postCustomer(@RequestBody LogFile logfile) {
	  //Current Time
	  SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
	  String current_time_str = time_formatter.format(System.currentTimeMillis());
      logger.debug("Calling postCustomer( )");
      String logTime = current_time_str;
      String logFileId = logfile.getLogFileId();
      repository.save(new LogFile(logTime,logFileId));
      return new ResponseEntity<Void>(HttpStatus.CREATED);
   }


}