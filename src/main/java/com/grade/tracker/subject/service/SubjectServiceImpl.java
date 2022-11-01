package com.grade.tracker.subject.service;

import com.grade.tracker.subject.dto.SubjectRequestDto;
import com.grade.tracker.subject.dto.SubjectResponseDto;
import com.grade.tracker.subject.mapper.SubjectMapper;
import com.grade.tracker.subject.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public SubjectServiceImpl(final SubjectRepository subjectRepository,final SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectResponseDto save(final SubjectRequestDto subjectRequestDto) {
        final var subject = subjectMapper.subjectRequestDtoToSubject(subjectRequestDto);
        subject.setId(UUID.randomUUID().toString());
        final var subjectSaved = subjectRepository.save(subject);
        return subjectMapper.subjectToSubjectResponseDto(subjectSaved);
    }

    @Override
    public List<SubjectResponseDto> findAll() {
        final var subjects = subjectRepository.findAll();
        return subjects.stream().map(subjectMapper::subjectToSubjectResponseDto).collect(Collectors.toList());
    }
}
