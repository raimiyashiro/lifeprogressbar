package com.raimiyashiro.lifeprogressbar.data.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Builder
@Entity
public class Progress {
    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private Integer currentLevel;
    private Integer totalXp;
}
