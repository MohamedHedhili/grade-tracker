package com.grade.tracker.person.dto;

import com.grade.tracker.schoolclass.dto.SchoolClassRequestDto;
import com.grade.tracker.subject.dto.SubjectRequestDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class TeacherRequestDto extends PersonRequestDto{
    private SchoolClassRequestDto schoolClassRequestDto;
    private SubjectRequestDto subjectRequestDto ;
}
