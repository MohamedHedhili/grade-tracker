package com.grade.tracker.person.dto;

import com.grade.tracker.shared.enumeration.Gender;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@SuperBuilder
public abstract class PersonRequestDto {
    private String id ;
    private String firstName;
    private String lastName;
    private Gender gender;
}
