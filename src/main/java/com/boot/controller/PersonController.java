package com.boot.controller;

import com.boot.entity.Person;
import com.boot.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class PersonController {
    
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @GetMapping
    public List<Person> listPersons (){
        return personRepository.findAll();
    }
    
    @GetMapping("/insert")
    public String insert (){
        for(int i = 0; i < 10; i++){
            personRepository.save(new Person("fname" + i, "lname" + i));
        }
        return "inserted";
    }
    
}
