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
@Table(name = "tb_user")
public class User implements Serializable {

   private static final long serialVersionUID = 1495599009435212192L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @NotEmpty(message = "The user Email must not be null")
   private String user_Email;
   
   @NotEmpty(message = "The user Nick must not be null")
   private String user_Nick;
   
   @NotEmpty(message = "The user enable must not be null")
   private String user_Enable;
   
   public User(int id, String Email, String Nick, String Enable){
      this.id=id;
      this.user_Email=Email;
      this.user_Enable=Enable;
      this.user_Nick=Nick;
   }
}