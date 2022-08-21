package com.raimiyashiro.lifeprogressbar.api.v1;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    private UUID id;
    private String name;
    @JsonManagedReference
    private Set<Activity> activities;
}
