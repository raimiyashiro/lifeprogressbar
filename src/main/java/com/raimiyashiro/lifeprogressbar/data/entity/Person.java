package com.raimiyashiro.lifeprogressbar.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Person {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    @OneToMany(mappedBy = "person")
    Set<Progress> skillsInProgress = new HashSet<>();
}
