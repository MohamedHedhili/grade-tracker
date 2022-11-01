package com.grade.tracker.subject.service;

import com.grade.tracker.subject.dto.SubjectRequestDto;
import com.grade.tracker.subject.dto.SubjectResponseDto;

import java.util.List;

public interface SubjectService {
    SubjectResponseDto save(final SubjectRequestDto subjectRequestDto);
    List<SubjectResponseDto> findAll();
}
