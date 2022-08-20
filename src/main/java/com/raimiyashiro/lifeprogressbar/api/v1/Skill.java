package com.raimiyashiro.lifeprogressbar.api.v1;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
@Builder
public class Skill {
    private UUID id;
    private String name;
    private Set<Activity> activities;
}
