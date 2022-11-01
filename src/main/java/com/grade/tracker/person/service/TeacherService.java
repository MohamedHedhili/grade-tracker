package com.grade.tracker.person.service;

import com.grade.tracker.person.dto.TeacherRequestDto;
import com.grade.tracker.person.dto.TeacherResponseDto;

import java.util.List;

public interface TeacherService extends PersonService<TeacherRequestDto , TeacherResponseDto>{
    List<TeacherResponseDto> findAllTeachers();
}
