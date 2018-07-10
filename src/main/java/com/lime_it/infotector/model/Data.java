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
@Table(name = "tb_data")

public class Data implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @NotEmpty(message = "The data colums must not be null")
   private String data_Columns;
   
   @NotEmpty(message = "The data types must not be null")
   private String data_Types;
   
   @NotEmpty(message = "The data methods must not be null")
   private String data_Methods;   
   
   public Data(String Columns, String Types, String Methods){
      this.data_Columns=Columns;
      this.data_Types=Types;
      this.data_Methods=Methods;
   }
}