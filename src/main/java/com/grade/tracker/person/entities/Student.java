package com.grade.tracker.person.entities;

import com.grade.tracker.grade.entities.Grade;
import com.grade.tracker.schoolclass.entities.SchoolClass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("student")
@SuperBuilder
public class Student extends Person {
    @ManyToOne
    private SchoolClass schoolClass;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<Grade> grades = new ArrayList<>();
}