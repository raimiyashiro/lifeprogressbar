package com.raimiyashiro.lifeprogressbar.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    @OneToMany(mappedBy = "skill")
    Set<Activity> activities = new HashSet<>();
}
