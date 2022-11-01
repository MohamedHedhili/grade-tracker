package com.grade.tracker.schoolclass.service;

import com.grade.tracker.schoolclass.dto.SchoolClassRequestDto;
import com.grade.tracker.schoolclass.dto.SchoolClassResponseDto;
import com.grade.tracker.schoolclass.mapper.SchoolClassMapper;
import com.grade.tracker.schoolclass.repository.SchoolClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchoolClassServiceImpl implements SchoolClassService{
    private final SchoolClassRepository schoolClassRepository;
    private final SchoolClassMapper schoolClassMapper;

    public SchoolClassServiceImpl(final SchoolClassRepository schoolClassRepository,final SchoolClassMapper schoolClassMapper) {
        this.schoolClassRepository = schoolClassRepository;
        this.schoolClassMapper = schoolClassMapper;
    }

    @Override
    public List<SchoolClassResponseDto> findAll() {
        final var schoolClasses = schoolClassRepository.findAll();
        return schoolClasses.stream().map(schoolClassMapper::SchoolClassToSchoolClassResponseDto).collect(Collectors.toList());
    }

    @Override
    public SchoolClassResponseDto save(final SchoolClassRequestDto schoolClassRequestDto) {
        final var schoolClass= schoolClassMapper.SchoolClassRequestDtoToSchoolClass(schoolClassRequestDto);
        schoolClass.setId(UUID.randomUUID().toString());
        final var schoolClassSaved = schoolClassRepository.save(schoolClass);
        return schoolClassMapper.SchoolClassToSchoolClassResponseDto(schoolClassSaved);
    }
}
