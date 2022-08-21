package com.raimiyashiro.lifeprogressbar.api.v1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
    private UUID id;
    @JsonBackReference
    private Person person;
    private Skill skill;
    private Integer currentLevel;
    private Integer totalXp;
}
