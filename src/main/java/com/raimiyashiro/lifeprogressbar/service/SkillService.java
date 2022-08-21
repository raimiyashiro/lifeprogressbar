package com.raimiyashiro.lifeprogressbar.service;

import com.raimiyashiro.lifeprogressbar.api.v1.Skill;
import com.raimiyashiro.lifeprogressbar.data.repository.SkillRepository;
import com.raimiyashiro.lifeprogressbar.exception.SkillCreationException;
import com.raimiyashiro.lifeprogressbar.exception.SkillNotFoundException;
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
        var result = skillRepository.findAll().stream().map(
                skill -> mapper.map(skill, Skill.class)
        ).collect(Collectors.toList());
        return result;
    }

    public Skill create(Skill skill) {
        var mapper = new ModelMapper();
        try {
            skill.setId(UUID.randomUUID());
            var result = skillRepository.save(
                    mapper.map(skill, com.raimiyashiro.lifeprogressbar.data.entity.Skill.class)
            );
            return mapper.map(result, Skill.class);
        } catch (Exception e) {
            throw new SkillCreationException();
        }
    }

    public Skill findById(UUID id) {
        var mapper = new ModelMapper();
        var skill = skillRepository.findById(id);
        if (skill.isPresent()) {
            return mapper.map(skill.get(), Skill.class);
        }
        throw new SkillNotFoundException();
    }
}
