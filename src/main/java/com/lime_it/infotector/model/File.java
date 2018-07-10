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
   private String fileName;
   
   @NotEmpty(message = "The file size must not be null")
   private String fileSize;
   
   @NotEmpty(message = "The file format must not be null")
   private String fileFormat;
   
   @NotEmpty(message = "The file contents must not be null")
   private String fileContents;
   
   @NotEmpty(message = "The file savetime must not be null")
   private String fileSavetime;
   
   @NotEmpty(message = "The file id must not be null")
   private String fileId;
   
   public File(String Name, String Format, String Contents, String Savetime, String Id, String Size){
      this.fileContents=Contents;
      this.fileFormat=Format;
      this.fileId=Id;
      this.fileName=Name;
      this.fileSavetime=Savetime;
      this.fileSize=Size;
   }
   
}