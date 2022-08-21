package com.raimiyashiro.lifeprogressbar.service;

import com.raimiyashiro.lifeprogressbar.api.v1.Person;
import com.raimiyashiro.lifeprogressbar.data.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(UUID id) {
        var mapper = new ModelMapper();
        return mapper.map(
                personRepository.getReferenceById(id), Person.class
        );
    }

    public Person create(Person person) {
        var mapper = new ModelMapper();
        person.setId(UUID.randomUUID());
        var result = personRepository.save(mapper.map(person, com.raimiyashiro.lifeprogressbar.data.entity.Person.class));
        return mapper.map(result, Person.class);
    }
}
