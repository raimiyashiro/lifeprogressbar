package com.raimiyashiro.lifeprogressbar.data.repository;

import com.raimiyashiro.lifeprogressbar.data.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {

    List<Activity> findBySkillId(UUID id);
}
