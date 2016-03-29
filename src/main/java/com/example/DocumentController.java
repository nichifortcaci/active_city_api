package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/document")
public class DocumentController {
    private DocumentRepository repository;

    @Autowired
    public DocumentController(DocumentRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "",method = RequestMethod.GET)
    public List<Document> getAll(){
        return repository.findAll();
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public Document insert(@RequestBody Document cat){
        return repository.save(cat);
    }

    @RequestMapping(path = "/{id}")
    public Document getOne(@PathVariable long id){
        return repository.findOne(id);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public Boolean removeOne(@PathVariable long id){
        repository.delete(id);

        return true;
    }

    @RequestMapping(path = "/findByName/{name}")
    public List<Document> findByName(@PathVariable String name){
        return repository.findByName(name);
    }
}
