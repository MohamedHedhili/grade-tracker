package com.grade.tracker.person.rest;

import com.grade.tracker.person.dto.StudentRequestDto;
import com.grade.tracker.person.dto.StudentResponseDto;
import com.grade.tracker.person.service.StudentService;
import com.grade.tracker.shared.exception.InternalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.grade.tracker.shared.CommonConstants.*;

@RestController
@RequestMapping(STUDENTS)
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(final StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping(SAVE)
    public ResponseEntity<StudentResponseDto> save(final @RequestBody StudentRequestDto studentRequestDto) throws InternalException {
        final var studentResponseDto =studentService.save(studentRequestDto);
        return ResponseEntity.ok().body(studentResponseDto);
    }


    @GetMapping()
    public ResponseEntity<List<StudentResponseDto>> getAll( ){
        final var studentResponseDtos = studentService.findAllStudents();
        return ResponseEntity.ok(studentResponseDtos);
    }
    @GetMapping(PARAM_SCHOOL_CLASS_ID)
    public ResponseEntity<List<StudentResponseDto>> getAllBySchoolClass(final @PathVariable String schoolClasId){
        final var studentsBySchoolClass = studentService.findStudentsBySchoolClass(schoolClasId);
        return ResponseEntity.ok(studentsBySchoolClass);
    }
}
