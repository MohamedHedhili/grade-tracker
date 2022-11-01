package com.grade.tracker.grade.service;

import com.grade.tracker.grade.dto.GradeRequestDto;
import com.grade.tracker.grade.dto.GradeResponseDto;
import com.grade.tracker.shared.exception.InternalException;

import java.util.List;

public interface GradeService {
    GradeResponseDto save(final GradeRequestDto gradeRequestDto) throws InternalException;
    void deleteByStudent(final String studentId);
    GradeResponseDto update( final GradeRequestDto gradeRequestDto);
    List<GradeResponseDto> getAllBySubjectAndStudent(final String SubjectId , final String studentId);

    List<GradeResponseDto> getAllByStudent(final String studentId);
}
