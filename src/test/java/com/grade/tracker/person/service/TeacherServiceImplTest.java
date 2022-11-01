package com.grade.tracker.person.service;

import com.grade.tracker.person.dto.TeacherRequestDto;
import com.grade.tracker.person.dto.TeacherResponseDto;
import com.grade.tracker.person.entities.Teacher;
import com.grade.tracker.person.mapper.PersonMapper;
import com.grade.tracker.person.repository.PersonRepository;
import com.grade.tracker.shared.enumeration.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceImplTest {
    @Mock
    private PersonRepository<Teacher> teacherPersonRepository;
    @Mock
    private PersonMapper personMapper;
    @InjectMocks
    private TeacherServiceImpl teacherService;
    @Test
    void should_create_when_teacher_request_dto_is_ok_then_teacher_is_create() {

        final var teacher = Teacher.builder().id("s1").firstName("patricia").lastName("cornille").gender(Gender.F).build();
        final var teacherRequestDto = TeacherRequestDto.builder().firstName("patricia").lastName("cornille").gender(Gender.F).build();
        final var teacherResponseDto = TeacherResponseDto.builder().id("s1").firstName("patricia").lastName("cornille").gender(Gender.F).build();
        //Given
        given(personMapper.teacherRequestDtoToTeacher(any(TeacherRequestDto.class))).willReturn(teacher);
        given(teacherPersonRepository.save(any(Teacher.class))).willReturn(teacher);
        given(personMapper.teacherToTeacherResponseDto(any(Teacher.class))).willReturn(teacherResponseDto);
        //When
        final var teacherSaved = teacherService.save(teacherRequestDto);
        //Then
        assertThat(teacherSaved).isNotNull();
        assertThat(teacherSaved.getId()).isNotNull();
        assertThat(teacherSaved.getGender()).isEqualTo(Gender.F);
        assertThat(teacherSaved.getFirstName()).isEqualTo("patricia");
        assertThat(teacherSaved.getLastName()).isEqualTo("cornille");
        assertThat(teacherSaved.getGender()).isEqualTo(Gender.F);
    }

    @Test
    void should_find_all_teachers_with_two_teachers_when_every_thing_is_okay_then_return_all_teachers_response_dtos() {

        final var teachers = List.of(Teacher.builder().id("t1").firstName("Mohamed").lastName("Hamdani").gender(Gender.M).build(),
                Teacher.builder().id("t2").firstName("Jullien").lastName("Konde").gender(Gender.M).build());
        final var teacherResponseDto1 = TeacherResponseDto.builder().id("t1").firstName("Mohamed").lastName("Hamdani").gender(Gender.M).build();
        final var teacherResponseDto2 = TeacherResponseDto.builder().id("t2").firstName("Jullien").lastName("Konde").gender(Gender.M).build();
        //Given
        given(teacherPersonRepository.findAll()).willReturn(teachers);
        given(personMapper.teacherToTeacherResponseDto(any(Teacher.class))).willReturn(teacherResponseDto1, teacherResponseDto2);
        //When
        final var teacherResponseDtoList = teacherService.findAllTeachers();
        //Then
        assertThat(teacherResponseDtoList).hasSameSizeAs(teachers);
        assertThat(teacherResponseDtoList.get(0).getId()).isEqualTo(teachers.get(0).getId());
        assertThat(teacherResponseDtoList.get(1).getId()).isEqualTo(teachers.get(1).getId());
        assertThat(teacherResponseDtoList.get(0).getLastName()).isEqualTo(teachers.get(0).getLastName());
        assertThat(teacherResponseDtoList.get(1).getLastName()).isEqualTo(teachers.get(1).getLastName());
        assertThat(teacherResponseDtoList.get(0).getFirstName()).isEqualTo(teachers.get(0).getFirstName());
        assertThat(teacherResponseDtoList.get(1).getFirstName()).isEqualTo(teachers.get(1).getFirstName());
    }
}
