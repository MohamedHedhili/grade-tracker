package com.grade.tracker.person.entities;

import com.grade.tracker.schoolclass.entities.SchoolClass;
import com.grade.tracker.subject.entities.Subject;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("teacher")
@SuperBuilder
public class Teacher extends Person {
    @OneToOne(mappedBy = "teacher")
    private SchoolClass schoolClass;
    @ManyToOne
    private Subject subject ;
}