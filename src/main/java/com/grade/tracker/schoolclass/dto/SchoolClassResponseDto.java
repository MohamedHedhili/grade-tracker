package com.grade.tracker.schoolclass.dto;

import com.grade.tracker.person.dto.TeacherResponseDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
public class SchoolClassResponseDto {
    private String id;
    private String levelName;
    private TeacherResponseDto teacherResponseDto ;
}
