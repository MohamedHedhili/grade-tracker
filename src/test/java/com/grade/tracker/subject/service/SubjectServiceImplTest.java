package com.grade.tracker.subject.service;

import com.grade.tracker.subject.dto.SubjectRequestDto;
import com.grade.tracker.subject.dto.SubjectResponseDto;
import com.grade.tracker.subject.entities.Subject;
import com.grade.tracker.subject.mapper.SubjectMapper;
import com.grade.tracker.subject.repository.SubjectRepository;
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
class SubjectServiceImplTest {
    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private SubjectMapper subjectMapper;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Test
    void should_create_when_subject_request_dto_is_ok_then_subject_is_create() {

        final var subject = Subject.builder().id("s1").name("algorithmic").build();
        final var subjectRequestDto = SubjectRequestDto.builder().name("algorithmic").build();
        final var subjectResponseDto = SubjectResponseDto.builder().id("s1").name("algorithmic").build();
        //Given
        given(subjectMapper.subjectRequestDtoToSubject(any(SubjectRequestDto.class))).willReturn(subject);
        given(subjectRepository.save(any(Subject.class))).willReturn(subject);
        given(subjectMapper.subjectToSubjectResponseDto(any(Subject.class))).willReturn(subjectResponseDto);
        //When
        final var subjectSaved = subjectService.save(subjectRequestDto);
        //Then
        assertThat(subjectSaved).isNotNull();
        assertThat(subjectSaved.getId()).isNotNull();
        assertThat(subjectSaved.getName()).isEqualTo("algorithmic");
    }

    @Test
    void should_find_all_with_two_subjects_when_every_thing_is_okay_then_return_all_subjects_response_dtos() {

        final var subjects = List.of(Subject.builder().id("s1").name("mathematics").build(),
                Subject.builder().id("s2").name("algorithmic").build());
        final var subjectResponseDto1 = SubjectResponseDto.builder().id("s1").name("mathematics").build();
        final var subjectResponseDto2 = SubjectResponseDto.builder().id("s2").name("algorithmic").build();
        //Given
        given(subjectRepository.findAll()).willReturn(subjects);
        given(subjectMapper.subjectToSubjectResponseDto(any(Subject.class))).willReturn(subjectResponseDto1, subjectResponseDto2);
        //When
        final var subjectResponseDtoList = subjectService.findAll();
        //Then
        assertThat(subjectResponseDtoList).hasSameSizeAs(subjects);
        assertThat(subjectResponseDtoList.get(0).getId()).isEqualTo("s1");
        assertThat(subjectResponseDtoList.get(1).getId()).isEqualTo("s2");
        assertThat(subjectResponseDtoList.get(0).getName()).isEqualTo("mathematics");
        assertThat(subjectResponseDtoList.get(1).getName()).isEqualTo("algorithmic");
        assertThat(subjectResponseDtoList).hasSameSizeAs(subjects);
    }


}
