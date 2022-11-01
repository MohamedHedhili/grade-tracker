package com.grade.tracker.grade.dto;

import com.grade.tracker.person.dto.StudentResponseDto;
import com.grade.tracker.subject.dto.SubjectResponseDto;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
public class GradeResponseDto {
    private String id ;
    private double value ;
    private SubjectResponseDto subjectResponseDto ;
    private StudentResponseDto studentResponseDto ;
}
