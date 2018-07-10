package com.lime_it.infotector.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "tb_logfile")
public class LogFile implements Serializable {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @NotEmpty(message = "The log time must not be null")
   private String logTime;   
   
   @NotEmpty(message = "The file id log must not be null")
   private String logFileId;   
   
   public LogFile(String logTime, String logFileId){
	   this.logTime=logTime;
	   this.logFileId=logFileId;
   }
}