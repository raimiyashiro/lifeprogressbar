package com.raimiyashiro.lifeprogressbar.data.repository;

import com.raimiyashiro.lifeprogressbar.data.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProgressRepository extends JpaRepository<Progress, UUID> {
}
