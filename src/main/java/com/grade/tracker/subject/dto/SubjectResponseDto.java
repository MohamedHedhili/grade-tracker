package com.grade.tracker.subject.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
public class SubjectResponseDto {
    private String id ;
    private String name ;
}
