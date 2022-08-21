package com.raimiyashiro.lifeprogressbar.api.v1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private UUID id;
    private String name;
    @JsonBackReference
    private Skill skill;
    private Integer xp;
}
