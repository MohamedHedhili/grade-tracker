package com.grade.tracker.schoolclass.service;

import com.grade.tracker.schoolclass.dto.SchoolClassRequestDto;
import com.grade.tracker.schoolclass.dto.SchoolClassResponseDto;

import java.util.List;

public interface SchoolClassService {
    List<SchoolClassResponseDto> findAll();
    SchoolClassResponseDto save(final SchoolClassRequestDto schoolClassRequestDto);
}
