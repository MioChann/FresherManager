package com.example.newProject.controller;

import com.example.newProject.entity.Fresher;
import com.example.newProject.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FresherController {
    private FresherService fresherService;
    @Autowired
    public FresherController(FresherService fresherService){
        this.fresherService = fresherService;
    }

    @PostMapping("/create")
    public ResponseEntity<Fresher> addFresher(@RequestBody Fresher fresher){
       fresherService.save(fresher);
       return new ResponseEntity<>(fresher,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Fresher> findFresherById(@PathVariable(name = "id") int id){
      Fresher fresher = fresherService.findById(id);
      return new ResponseEntity<>(fresher,HttpStatus.OK);
    }
    @GetMapping("/showAll")
    public ResponseEntity<List<Fresher>> find(){
       List<Fresher> freshers =  fresherService.findAll();
       return new ResponseEntity<>(freshers,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
       fresherService.delete(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Fresher> updateFresher(@PathVariable int id, @RequestBody Fresher fresher){
        Fresher m = fresherService.update(id,fresher);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
}
