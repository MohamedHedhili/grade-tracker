package com.grade.tracker.person.rest;

import com.grade.tracker.person.dto.TeacherRequestDto;
import com.grade.tracker.person.dto.TeacherResponseDto;
import com.grade.tracker.person.service.TeacherService;
import com.grade.tracker.shared.exception.InternalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.grade.tracker.shared.CommonConstants.SAVE;
import static com.grade.tracker.shared.CommonConstants.TEACHERS;

@RestController
@RequestMapping(TEACHERS)
public class TeacherRestController {
    private final TeacherService teacherService ;

    public TeacherRestController(final TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping(SAVE)
    public ResponseEntity<TeacherResponseDto> save(final @RequestBody TeacherRequestDto teacherRequestDto) throws InternalException {
        final var teacherResponseDto =teacherService.save(teacherRequestDto);
        return ResponseEntity.ok().body(teacherResponseDto);
    }


    @GetMapping()
    public ResponseEntity<List<TeacherResponseDto>> getAll( ){
        final var teacherResponseDtos = teacherService.findAllTeachers();
        return ResponseEntity.ok(teacherResponseDtos);
    }
}
