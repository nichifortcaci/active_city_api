package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nick on 2/7/16.
 */
@RestController
@RequestMapping(path = "/api/cat")
public class CatController {
    private CatRepository repository;

    @Autowired
    public CatController(CatRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "",method = RequestMethod.GET)
    public List<Cat> getAll(){
        return repository.findAll();
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public Cat insert(@RequestBody Cat cat){
        return repository.save(cat);
    }

    @RequestMapping(path = "/{id}")
    public Cat getOne(@PathVariable long id){
        return repository.findOne(id);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public Boolean removeOne(@PathVariable long id){
        repository.delete(id);

        return true;
    }

    @RequestMapping(path = "/findByName/{name}")
    public List<Cat> findByName(@PathVariable String name){
        return repository.findByName(name);
    }
}
