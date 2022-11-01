package com.grade.tracker.person.mapper;

import com.grade.tracker.person.dto.*;
import com.grade.tracker.person.entities.Student;
import com.grade.tracker.person.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "schoolClassRequestDto.id", target = "schoolClass.id")
    Student studentRequestDtoToStudent(final StudentRequestDto studentRequestDto);
    @Mapping(source = "schoolClass.id", target = "schoolClassResponseDto.id")
    @Mapping(source = "schoolClass.levelName", target = "schoolClassResponseDto.levelName")
    StudentResponseDto studentToStudentResponseDto(final Student student);
    @Mapping(source = "schoolClassRequestDto.id", target = "schoolClass.id")
    @Mapping(source = "subjectRequestDto.id", target = "subject.id")
    Teacher teacherRequestDtoToTeacher(final TeacherRequestDto teacherRequestDto);
    @Mapping(source = "schoolClass.id", target = "schoolClassResponseDto.id")
    @Mapping(source = "schoolClass.levelName", target = "schoolClassResponseDto.levelName")
    @Mapping(source = "subject.id", target = "subjectResponseDto.id")
    @Mapping(source = "subject.name", target = "subjectResponseDto.name")
    TeacherResponseDto teacherToTeacherResponseDto(final Teacher teacher);
}
