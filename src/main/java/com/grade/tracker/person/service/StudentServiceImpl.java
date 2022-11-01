package com.grade.tracker.person.service;

import com.grade.tracker.person.dto.*;
import com.grade.tracker.person.mapper.PersonMapper;
import com.grade.tracker.person.repository.StudentRepository;
import com.grade.tracker.schoolclass.entities.SchoolClass;
import com.grade.tracker.shared.exception.InternalException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.grade.tracker.shared.CommonConstants.FIRSTNAME;
import static com.grade.tracker.shared.CommonConstants.LASTNAME;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    private final PersonMapper personMapper;

    public StudentServiceImpl(final StudentRepository studentRepository, final PersonMapper personMapper) {
        this.studentRepository = studentRepository;
        this.personMapper = personMapper;
    }

    @Override
    public StudentResponseDto save(final StudentRequestDto personRequestDto) throws InternalException {
        final var student = personMapper.studentRequestDtoToStudent(personRequestDto);
        student.setId(UUID.randomUUID().toString());
        if(Objects.isNull(student.getSchoolClass().getId()))
            throw new InternalException("You cannot add student without specify class school");
        final var studentSaved = studentRepository.save( student);
        return personMapper.studentToStudentResponseDto(studentSaved);
    }

    @Override
    public List<StudentResponseDto> findStudentsBySchoolClass(final String schoolClassId) {
        final var schoolClass = SchoolClass.builder().id(schoolClassId).build();
        final var studentsBySchoolClass = studentRepository.findAllBySchoolClass(schoolClass);
        return  Objects.isNull(studentsBySchoolClass) ?
                Collections.emptyList() :
                studentsBySchoolClass.stream().map(personMapper::studentToStudentResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDto> findAllStudents() {
        final var students = studentRepository.findAll(Sort.by(Sort.Direction.ASC, FIRSTNAME , LASTNAME));
        return students.stream().map(personMapper::studentToStudentResponseDto).collect(Collectors.toList());
    }
}
