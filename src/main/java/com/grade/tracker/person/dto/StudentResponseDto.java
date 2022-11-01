package com.grade.tracker.person.dto;

import com.grade.tracker.schoolclass.dto.SchoolClassResponseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class StudentResponseDto extends PersonResponseDto{
    private SchoolClassResponseDto schoolClassResponseDto;
}
