package com.grade.tracker.person.service;

import com.grade.tracker.person.dto.*;
import com.grade.tracker.person.mapper.PersonMapper;
import com.grade.tracker.person.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;

    private final PersonMapper personMapper;

    public TeacherServiceImpl(final TeacherRepository teacherRepository, final PersonMapper personMapper) {
        this.teacherRepository = teacherRepository;
        this.personMapper = personMapper;
    }

    @Override
    public TeacherResponseDto save(final TeacherRequestDto teacherRequestDto) {
        final var teacher = personMapper.teacherRequestDtoToTeacher(teacherRequestDto);
        teacher.setId(UUID.randomUUID().toString());
        final var teacherSaved = teacherRepository.save( teacher);
        return personMapper.teacherToTeacherResponseDto(teacherSaved);
    }
    @Override
    public List<TeacherResponseDto> findAllTeachers() {
        final var teachers = teacherRepository.findAll();
        return teachers.stream().map(personMapper::teacherToTeacherResponseDto).collect(Collectors.toList());
    }
}
