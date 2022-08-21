package com.raimiyashiro.lifeprogressbar.data.repository;

import com.raimiyashiro.lifeprogressbar.data.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, UUID> {
}
