package com.grade.tracker.schoolclass.dto;

import com.grade.tracker.person.dto.TeacherRequestDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
public class SchoolClassRequestDto {
    private String id;
    private String levelName;
    private TeacherRequestDto teacherRequestDto ;
}
