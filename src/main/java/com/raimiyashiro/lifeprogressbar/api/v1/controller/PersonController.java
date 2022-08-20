package com.raimiyashiro.lifeprogressbar.api.v1.controller;

import com.raimiyashiro.lifeprogressbar.api.v1.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @GetMapping("/{id}")
    public Person get(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public Person post(@RequestBody Person person) {
        return null;
    }
}
