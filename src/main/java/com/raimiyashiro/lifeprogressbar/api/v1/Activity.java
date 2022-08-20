package com.raimiyashiro.lifeprogressbar.api.v1;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Activity {
    private UUID id;
    private String name;
    private Skill skill;
    private Integer xp;
}
