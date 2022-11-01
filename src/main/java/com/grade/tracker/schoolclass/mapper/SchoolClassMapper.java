package com.grade.tracker.schoolclass.mapper;

import com.grade.tracker.schoolclass.dto.SchoolClassRequestDto;
import com.grade.tracker.schoolclass.dto.SchoolClassResponseDto;
import com.grade.tracker.schoolclass.entities.SchoolClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolClassMapper {
    @Mapping(source = "teacherRequestDto", target = "teacher")
    SchoolClass SchoolClassRequestDtoToSchoolClass(final SchoolClassRequestDto schoolClassRequestDto);
    @Mapping(source = "teacher", target = "teacherResponseDto")
    SchoolClassResponseDto SchoolClassToSchoolClassResponseDto(final SchoolClass schoolClass);
}
