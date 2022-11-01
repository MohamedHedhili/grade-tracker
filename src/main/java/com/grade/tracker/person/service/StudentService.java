package com.grade.tracker.person.service;

import com.grade.tracker.person.dto.StudentRequestDto;
import com.grade.tracker.person.dto.StudentResponseDto;

import java.util.List;

public interface StudentService extends PersonService <StudentRequestDto , StudentResponseDto> {
    List<StudentResponseDto> findStudentsBySchoolClass(final String schoolClassId);
    List<StudentResponseDto> findAllStudents();
}
