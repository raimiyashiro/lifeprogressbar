package com.raimiyashiro.lifeprogressbar.api.v1.controller;

import com.raimiyashiro.lifeprogressbar.api.v1.Activity;
import com.raimiyashiro.lifeprogressbar.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/skill/{skillId}")
    public List<Activity> getAll(@PathVariable UUID skillId) {
        return activityService.list(skillId);
    }

    @PostMapping
    public Activity post(@RequestBody Activity activity) {
        return activityService.create(activity);
    }
}
