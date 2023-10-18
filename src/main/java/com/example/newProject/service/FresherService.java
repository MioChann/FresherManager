package com.example.newProject.service;

import com.example.newProject.entity.Fresher;

import java.util.List;

public interface FresherService {

    public Fresher findById(int id);

    public List<Fresher> findAll();

    public void save(Fresher fresher);

    public void delete(int id);

    public Fresher update(int id,Fresher updateFresher);
}

