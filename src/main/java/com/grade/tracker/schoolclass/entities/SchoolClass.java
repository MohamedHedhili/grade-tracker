package com.grade.tracker.schoolclass.entities;

import com.grade.tracker.person.entities.Student;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {
    @Id
    private String id;
    @NotEmpty
    private String levelName;
    @OneToOne
    private Teacher teacher ;
    @OneToMany(mappedBy = "schoolClass")
    @ToString.Exclude
    private List<Student> students = new ArrayList<>();

}