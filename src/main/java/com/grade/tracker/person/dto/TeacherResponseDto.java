package com.grade.tracker.person.dto;

import com.grade.tracker.schoolclass.dto.SchoolClassResponseDto;
import com.grade.tracker.subject.dto.SubjectResponseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class TeacherResponseDto extends PersonResponseDto{
    private SchoolClassResponseDto schoolClassResponseDto;
    private SubjectResponseDto subjectResponseDto ;
}
