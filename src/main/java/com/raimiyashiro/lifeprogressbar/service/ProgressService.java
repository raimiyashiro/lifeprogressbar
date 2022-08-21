package com.raimiyashiro.lifeprogressbar.service;

import com.raimiyashiro.lifeprogressbar.api.v1.Person;
import com.raimiyashiro.lifeprogressbar.api.v1.Progress;
import com.raimiyashiro.lifeprogressbar.api.v1.Skill;
import com.raimiyashiro.lifeprogressbar.data.repository.ProgressRepository;
import com.raimiyashiro.lifeprogressbar.exception.ProgressCreationException;
import com.raimiyashiro.lifeprogressbar.exception.ProgressNotFoundException;
import com.raimiyashiro.lifeprogressbar.exception.ProgressTrackingException;
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
        var progress = progressRepository.findById(id);

        if (progress.isPresent()) {
            return Progress.builder()
                    .person(mapper.map(progress.get().getPerson(), Person.class))
                    .skill(mapper.map(progress.get().getSkill(), Skill.class))
                    .currentLevel(progress.get().getCurrentLevel())
                    .totalXp(progress.get().getTotalXp())
                    .build();
        }
        throw new ProgressNotFoundException();
    }

    public Progress create(Progress progress) {
        var mapper = new ModelMapper();
        try {
            progress.setId(UUID.randomUUID());
            var result = progressRepository.save(
                    mapper.map(progress, com.raimiyashiro.lifeprogressbar.data.entity.Progress.class));
            return mapper.map(result, Progress.class);
        } catch (Exception e) {
            throw new ProgressCreationException();
        }
    }

    public Progress update(UUID id, Progress progress) {
        try {
            var existingProgress = progressRepository.getReferenceById(id);
            var mapper = new ModelMapper();
            var currentXp = existingProgress.getTotalXp();
            var comingXp = progress.getSkill().getActivities().stream()
                    .map(activity -> activity.getXp())
                    .reduce(0, Integer::sum);
            existingProgress.setTotalXp(currentXp + comingXp);
            return mapper.map(progressRepository.save(existingProgress), Progress.class);
        } catch (Exception e) {
            throw new ProgressTrackingException();
        }
    }
}
