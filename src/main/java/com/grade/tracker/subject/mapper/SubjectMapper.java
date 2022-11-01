package com.grade.tracker.subject.mapper;

import com.grade.tracker.subject.dto.SubjectRequestDto;
import com.grade.tracker.subject.dto.SubjectResponseDto;
import com.grade.tracker.subject.entities.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject subjectRequestDtoToSubject(final SubjectRequestDto subjectRequestDto);
    SubjectResponseDto subjectToSubjectResponseDto(final Subject subject);
}
