package com.grade.tracker.person.dto;

import com.grade.tracker.schoolclass.dto.SchoolClassRequestDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class StudentRequestDto extends PersonRequestDto{
    private SchoolClassRequestDto schoolClassRequestDto;
}
