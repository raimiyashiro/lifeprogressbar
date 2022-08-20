package com.raimiyashiro.lifeprogressbar.service;

import com.raimiyashiro.lifeprogressbar.api.v1.Progress;
import com.raimiyashiro.lifeprogressbar.data.repository.ProgressRepository;
import com.raimiyashiro.lifeprogressbar.exception.ProgressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProgressService {

    @Autowired
    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    private final ProgressRepository progressRepository;

    public Progress findById(UUID id) {
        Optional<com.raimiyashiro.lifeprogressbar.data.entity.Progress> progress = progressRepository.findById(id);
        if (progress.isPresent()) {
            return Progress.builder()
                    .person(null) // implement mapper
                    .skill(null) // implement mapper
                    .currentLevel(progress.get().getCurrentLevel())
                    .totalXp(progress.get().getTotalXp())
                    .build();
        }
        throw new ProgressNotFoundException();
    }

    public Progress create(Progress progress) {
        return null;
    }

    public Progress update(UUID id, Progress progress) {
        return null;
    }
}
