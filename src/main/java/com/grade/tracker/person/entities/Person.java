package com.grade.tracker.person.entities;

import com.grade.tracker.shared.enumeration.Gender;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type" , discriminatorType = DiscriminatorType.STRING)
@SuperBuilder
public abstract class Person {
    @Id
    private String id ;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;
}