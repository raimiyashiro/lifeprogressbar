package com.raimiyashiro.lifeprogressbar.api.v1;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private UUID id;
    private String name;
    @JsonManagedReference
    private Set<Progress> skillsInProgress;
}
