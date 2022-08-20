package com.raimiyashiro.lifeprogressbar.api.v1.controller;

import com.raimiyashiro.lifeprogressbar.api.v1.Progress;
import com.raimiyashiro.lifeprogressbar.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/progress")
public class ProgressController {

    @Autowired
    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    private final ProgressService progressService;

    @GetMapping("/{id}")
    public Progress get(@PathVariable UUID id) {
        return progressService.findById(id);
    }

    @PostMapping
    public Progress post(@RequestBody Progress progress) {
        return progressService.create(progress);
    }

    @PutMapping("/{id}/track")
    public Progress track(@PathVariable UUID id, @RequestBody Progress progress) {
        return progressService.update(id, progress);
    }
}
