package com.raimiyashiro.lifeprogressbar.api.v1;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class Person {
    private UUID id;
    private String name;
    private Set<Progress> skillsInProgress;
}
