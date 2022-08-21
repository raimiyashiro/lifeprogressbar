package com.raimiyashiro.lifeprogressbar.service;

import com.raimiyashiro.lifeprogressbar.api.v1.Activity;
import com.raimiyashiro.lifeprogressbar.api.v1.Person;
import com.raimiyashiro.lifeprogressbar.api.v1.Progress;
import com.raimiyashiro.lifeprogressbar.api.v1.Skill;
import com.raimiyashiro.lifeprogressbar.data.repository.ProgressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProgressService {

    @Autowired
    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    private final ProgressRepository progressRepository;

    public Progress findById(UUID id) {
        var mapper = new ModelMapper();
        var progress = progressRepository.getReferenceById(id);

        return Progress.builder()
                .person(mapper.map(progress.getPerson(), Person.class))
                .skill(mapper.map(progress.getSkill(), Skill.class))
                .currentLevel(progress.getCurrentLevel())
                .totalXp(progress.getTotalXp())
                .build();
    }

    public Progress create(Progress progress) {
        var mapper = new ModelMapper();
        progress.setId(UUID.randomUUID());
        var comingXp = progress.getSkill().getActivities().stream()
                .map(Activity::getXp)
                .reduce(0, Integer::sum);
        progress.setTotalXp(comingXp);

        var result = progressRepository.save(
                mapper.map(progress, com.raimiyashiro.lifeprogressbar.data.entity.Progress.class));
        return mapper.map(result, Progress.class);
    }

    public Progress update(UUID id, Progress progress) {
        var existingProgress = progressRepository.getReferenceById(id);
        var mapper = new ModelMapper();
        var currentXp = existingProgress.getTotalXp();
        var comingXp = progress.getSkill().getActivities().stream()
                .map(Activity::getXp)
                .reduce(0, Integer::sum);
        existingProgress.setTotalXp(currentXp + comingXp);
        return mapper.map(progressRepository.save(existingProgress), Progress.class);
    }
}
