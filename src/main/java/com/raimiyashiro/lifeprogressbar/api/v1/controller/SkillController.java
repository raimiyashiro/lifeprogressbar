package com.raimiyashiro.lifeprogressbar.api.v1.controller;

import com.raimiyashiro.lifeprogressbar.api.v1.Skill;
import com.raimiyashiro.lifeprogressbar.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/skill")
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable UUID id) {
        return skillService.findById(id);
    }

    @PostMapping
    public Skill post(@RequestBody Skill skill) {
        return skillService.create(skill);
    }

}
