package com.raimiyashiro.lifeprogressbar.api.v1;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    private UUID id;
    private String name;
    @JsonManagedReference
    private Set<Activity> activities;
}
