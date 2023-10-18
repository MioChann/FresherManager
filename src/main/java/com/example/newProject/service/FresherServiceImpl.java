package com.example.newProject.service;

import com.example.newProject.entity.Fresher;
import com.example.newProject.repository.FresherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FresherServiceImpl implements FresherService{
    FresherRepository fresherRepository;
    @Autowired
    public FresherServiceImpl(FresherRepository fresherRepository){
        this.fresherRepository = fresherRepository;
    }
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Fresher findById(int id) {
      return mongoTemplate.findById(id,Fresher.class);
    }

    @Override
    public List<Fresher> findAll() {
       return mongoTemplate.findAll(Fresher.class);
    }

    @Override
    public void save(Fresher fresher){
        mongoTemplate.save(fresher);
    }

    @Override
    public void delete(int id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)),Fresher.class);
    }

    @Override
    public Fresher update(int id, Fresher updateFresher) {
        Fresher fresher = findById(id);
        fresher.setId(updateFresher.getId());
        fresher.setName(updateFresher.getName());
        fresher.setAge(updateFresher.getAge());
        fresher.setPhoneNumber(updateFresher.getPhoneNumber());
        fresherRepository.save(fresher);
        return fresher;
    }

}
