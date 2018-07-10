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
@Table(name = "tb_logdata")
public class LogData implements Serializable {
	private static final long serialVersionUID = 7866308154766966953L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "The log time must not be null")
	private String logTime;

	@NotEmpty(message = "The data log must not be null")
	private String logData;
	
	public LogData(String logTime, String logData){
		this.logTime=logTime;
		this.logData=logData;
	}
}