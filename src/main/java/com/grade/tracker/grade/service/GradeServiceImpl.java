package com.grade.tracker.grade.service;

import com.grade.tracker.grade.dto.GradeRequestDto;
import com.grade.tracker.grade.dto.GradeResponseDto;
import com.grade.tracker.grade.mapper.GradeMapper;
import com.grade.tracker.grade.repository.GradeRepository;
import com.grade.tracker.person.entities.Student;
import com.grade.tracker.shared.exception.InternalException;
import com.grade.tracker.subject.entities.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class GradeServiceImpl implements GradeService{
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper ;

    public GradeServiceImpl(final GradeRepository gradeRepository,final GradeMapper gradeMapper) {
        this.gradeRepository = gradeRepository;
        this.gradeMapper = gradeMapper;
    }

    @Override
    public GradeResponseDto save(final GradeRequestDto gradeRequestDto) throws InternalException {
        final var grade =  gradeMapper.gradeRequestDtoToGrade(gradeRequestDto);
        grade.setId(UUID.randomUUID().toString());
        if(Objects.isNull(grade.getStudent().getId()))
            throw new InternalException("You cannot add grade without specify student id");
        if(Objects.isNull(grade.getSubject().getId()))
            throw new InternalException("You cannot add grade without specify subject id");
        final var gradeSaved = gradeRepository.save(grade);
        return gradeMapper.gradeToGradeResponseDto(gradeSaved);
    }

    @Override
    public void deleteByStudent(final String studentId) {
        final var student = Student.builder().id(studentId).build();
        gradeRepository.deleteByStudent(student);
    }

    @Override
    public GradeResponseDto update(final GradeRequestDto gradeRequestDto) {
        final var grade = gradeMapper.gradeRequestDtoToGrade(gradeRequestDto);
        final var gradeUpdated =gradeRepository.save(grade);
        return gradeMapper.gradeToGradeResponseDto(gradeUpdated);
    }

    @Override
    public List<GradeResponseDto> getAllBySubjectAndStudent(final String subjectId,final String studentId) {
        final var subject = Subject.builder().id(subjectId).build();
        final var student = Student.builder().id(studentId).build();
        final var grades = gradeRepository.findAllBySubjectAndStudent(subject ,student);
        return grades.stream().map(gradeMapper::gradeToGradeResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<GradeResponseDto> getAllByStudent(final String studentId) {
        final var student = Student.builder().id(studentId).build();
        final var grades = gradeRepository.findAllByStudent(student);
        return grades.stream().map(gradeMapper::gradeToGradeResponseDto).collect(Collectors.toList());
    }
}
