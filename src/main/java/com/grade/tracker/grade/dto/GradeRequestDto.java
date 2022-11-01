package com.grade.tracker.grade.dto;

import com.grade.tracker.person.dto.StudentRequestDto;
import com.grade.tracker.subject.dto.SubjectRequestDto;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
public class GradeRequestDto {
    private String id;
    private double value ;
    private SubjectRequestDto subjectRequestDto ;
    private StudentRequestDto studentRequestDto ;
}
