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

import com.lime_it.infotector.model.LogData;
import com.lime_it.infotector.repo.LogDataRepository;

@RestController
@RequestMapping("/api/logdatas")
public class LogDataController {

	@Autowired
	LogDataRepository repository;
	static Logger logger = LoggerFactory.getLogger(LogDataController.class);

	@GetMapping(value = "/logdatas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LogData>> getLogFileAll() {
		logger.debug("Calling getAll( )");
		List<LogData> list = new ArrayList<>();
		Iterable<LogData> log_files = repository.findAll();
		log_files.forEach(list::add);
		return new ResponseEntity<List<LogData>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/logdatas")
	public ResponseEntity<Void> postCustomer(@RequestBody LogData logdata) {
		// Current Time
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		String current_time_str = time_formatter.format(System.currentTimeMillis());
		logger.debug("Calling postCustomer( )");
		String logTime = current_time_str;
		String logData = logdata.getLogData();
		repository.save(new LogData(logTime, logData));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}