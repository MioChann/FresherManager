package com.example.newProject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "fresher")
@AllArgsConstructor
@NoArgsConstructor
public class Fresher {
  @Field(name = "id")
  private int id;
  @Field(name = "name")
  private String name;
  @Field(name ="age")
  private int  age;
  @Field(name ="phoneNumber")
  private int phoneNumber;
}
