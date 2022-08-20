package com.raimiyashiro.lifeprogressbar.api.v1;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Progress {
    private UUID id;
    private Person person;
    private Skill skill;
    private Integer currentLevel;
    private Integer totalXp;
}
