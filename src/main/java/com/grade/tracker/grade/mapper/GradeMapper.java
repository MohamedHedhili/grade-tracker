package com.grade.tracker.grade.mapper;

import com.grade.tracker.grade.dto.GradeRequestDto;
import com.grade.tracker.grade.dto.GradeResponseDto;
import com.grade.tracker.grade.entities.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    @Mapping(source = "subjectRequestDto.id", target = "subject.id")
    @Mapping(source = "studentRequestDto", target = "student")
    Grade gradeRequestDtoToGrade(final GradeRequestDto gradeRequestDto);
    @Mapping(source = "subject", target = "subjectResponseDto")
    @Mapping(source = "student", target = "studentResponseDto")
    GradeResponseDto gradeToGradeResponseDto(final Grade grade);
}
