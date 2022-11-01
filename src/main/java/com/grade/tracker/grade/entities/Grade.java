package com.grade.tracker.grade.entities;

import com.grade.tracker.person.entities.Student;
import com.grade.tracker.subject.entities.Subject;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grade {
    @Id
    private String id ;
    @Max(20)
    @Min(0)
    private double value ;
    @ManyToOne
    private Subject subject ;
    @ManyToOne
    private Student student ;
}