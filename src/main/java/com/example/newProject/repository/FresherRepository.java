package com.example.newProject.repository;

import com.example.newProject.entity.Fresher;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface FresherRepository extends MongoRepository<Fresher,Integer>{

}