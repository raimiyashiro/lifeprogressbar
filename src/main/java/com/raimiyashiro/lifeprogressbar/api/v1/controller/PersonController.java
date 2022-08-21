package com.raimiyashiro.lifeprogressbar.api.v1.controller;

import com.raimiyashiro.lifeprogressbar.api.v1.Person;
import com.raimiyashiro.lifeprogressbar.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/{id}")
    public Person get(@PathVariable UUID id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person post(@RequestBody Person person) {
        return personService.create(person);
    }
}
