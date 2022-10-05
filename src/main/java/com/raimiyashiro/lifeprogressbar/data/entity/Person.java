package com.raimiyashiro.lifeprogressbar.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String phone;
    private String email;
    private String gender;
    @OneToMany(mappedBy = "person")
    Set<Progress> skillsInProgress = new HashSet<>();
}
