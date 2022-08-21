package com.raimiyashiro.lifeprogressbar.data.repository;

import com.raimiyashiro.lifeprogressbar.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
