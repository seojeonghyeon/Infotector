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

import com.lime_it.infotector.model.Data;
import com.lime_it.infotector.model.File;
import com.lime_it.infotector.repo.DataRepository;

@RestController
@RequestMapping("/api/data")
public class DataController {

   @Autowired
   DataRepository repository;

   static Logger logger = LoggerFactory.getLogger(DataController.class);

   @GetMapping(value = "/datas", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Data>> getAll() {

      logger.debug("Calling getAll( )");
      List<Data> list = new ArrayList<>();
      Iterable<Data> datas = repository.findAll();
      datas.forEach(list::add);
      return new ResponseEntity<List<Data>>(list, HttpStatus.OK);

   }

   @PostMapping(value = "/datas")
   public ResponseEntity<Void> postCustomer(@RequestBody Data data, @RequestBody File file) {

      logger.debug("Calling postCustomer( )");
      String dataColumns = data.getData_Columns();
      String dataTypes = data.getData_Types();
      String dataMethods = data.getData_Methods();
      String fileId = file.getFileId();
      repository.save(new Data(dataColumns,dataTypes,dataMethods, fileId));
      return new ResponseEntity<Void>(HttpStatus.CREATED);
   }

   @GetMapping(value = "/datas/{fileId}/{dataColumns}/{datTypes}/{dataMethods}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Data>> updateData(@PathVariable String fildId, @PathVariable String dataColumns, @PathVariable String dataTypes, @PathVariable String dataMehtods) {
      logger.debug("Calling findByEmail( )");
      List<Data> datas = repository.findByFileId(fildId);
      if(datas.isEmpty()){
    	  return new ResponseEntity<List<Data>>(datas, HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Data>>(datas, HttpStatus.OK);
   }

   @DeleteMapping(value = "datas/{fileId}")
   public ResponseEntity<Void> deleteUser(@PathVariable String fileId) {
      logger.debug("Calling deleteUser( )");
      repository.findByFileId(fileId);
      return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
   }
}