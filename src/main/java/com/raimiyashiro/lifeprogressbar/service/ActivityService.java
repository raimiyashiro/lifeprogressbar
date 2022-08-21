package com.raimiyashiro.lifeprogressbar.service;

import com.raimiyashiro.lifeprogressbar.api.v1.Activity;
import com.raimiyashiro.lifeprogressbar.data.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity create(Activity activity) {
        var mapper = new ModelMapper();
        activity.setId(UUID.randomUUID());
        var result = activityRepository.save(mapper.map(activity, com.raimiyashiro.lifeprogressbar.data.entity.Activity.class));
        return mapper.map(result, Activity.class);
    }

    public List<Activity> list(UUID skillId) {
        var mapper = new ModelMapper();
        return activityRepository.findBySkillId(skillId).stream().map(
                activity -> mapper.map(activity, Activity.class)
        ).collect(Collectors.toList());
    }
}
