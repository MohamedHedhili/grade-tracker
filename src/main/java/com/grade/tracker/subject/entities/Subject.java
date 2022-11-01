package com.grade.tracker.subject.entities;

import com.grade.tracker.grade.entities.Grade;
import com.grade.tracker.person.entities.Teacher;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    @Id
    private String id ;
    @NotEmpty
    private String name ;
    @OneToMany(mappedBy = "subject")
    @ToString.Exclude
    private List<Teacher> teachers = new ArrayList<>();
    @OneToMany(mappedBy = "subject")
    @ToString.Exclude
    private List<Grade> grades = new ArrayList<>();
}