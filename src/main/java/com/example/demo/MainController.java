package com.example.demo;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/people")
public class MainController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping() 
    public @ResponseBody String addNewPerson( @RequestBody Person person) {
        // Person p = new Person(email,password);
        personRepository.save(person);
        return "Saved";  
    }
    

    @GetMapping()
    public @ResponseBody Iterable<Person> getAll() {
        Iterable<Person> res = Collections.emptyList();
        try {
            res = personRepository.findAll();        
            
        } catch (Exception e) {
            
            e.printStackTrace();;
        }
        return res;        
    }
    @GetMapping("/{id}")
    public @ResponseBody Optional<Person> getOne( @PathVariable String id) {
        Optional<Person> res = Optional.empty();
        try {
            res = personRepository.findById(Integer.valueOf(id));        
            
        } catch (Exception e) {
            
            e.printStackTrace();;
        }
        return res;        
    }
}
