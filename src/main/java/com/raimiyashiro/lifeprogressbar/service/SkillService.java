package com.raimiyashiro.lifeprogressbar.service;

import com.raimiyashiro.lifeprogressbar.api.v1.Skill;
import com.raimiyashiro.lifeprogressbar.data.repository.SkillRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAll() {
        var mapper = new ModelMapper();
        return skillRepository.findAll().stream().map(
                skill -> mapper.map(skill, Skill.class)
        ).collect(Collectors.toList());
    }

    public Skill create(Skill skill) {
        var mapper = new ModelMapper();
        skill.setId(UUID.randomUUID());
        var result = skillRepository.save(
                mapper.map(skill, com.raimiyashiro.lifeprogressbar.data.entity.Skill.class)
        );
        return mapper.map(result, Skill.class);
    }

    public Skill findById(UUID id) {
        var mapper = new ModelMapper();
        var skill = skillRepository.getReferenceById(id);
        return mapper.map(skill, Skill.class);
    }
}
