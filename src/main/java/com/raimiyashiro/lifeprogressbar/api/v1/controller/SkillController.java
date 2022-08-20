package com.raimiyashiro.lifeprogressbar.api.v1.controller;

import com.raimiyashiro.lifeprogressbar.api.v1.Skill;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skill")
public class SkillController {

    @GetMapping("/{id}")
    public Skill get(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public Skill post(@RequestBody Skill skill) {
        return null;
    }

}
