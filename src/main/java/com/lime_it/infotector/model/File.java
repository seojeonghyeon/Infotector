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
@Table(name = "tb_file")

public class File implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @NotEmpty(message = "The file name must not be null")
   private String file_Name;
   
   @NotEmpty(message = "The file size must not be null")
   private String file_Size;
   
   @NotEmpty(message = "The file format must not be null")
   private String file_Format;
   
   @NotEmpty(message = "The file contents must not be null")
   private String file_Contents;
   
   @NotEmpty(message = "The file savetime must not be null")
   private String file_Savetime;
   
   @NotEmpty(message = "The file id must not be null")
   private String file_Id;
   
   public File(String Name, String Format, String Contents, String Savetime, String Id, String Size){
      this.file_Contents=Contents;
      this.file_Format=Format;
      this.file_Id=Id;
      this.file_Name=Name;
      this.file_Savetime=Savetime;
      this.file_Size=Size;
   }
   
}