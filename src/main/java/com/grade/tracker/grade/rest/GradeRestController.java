package com.grade.tracker.grade.rest;

import com.grade.tracker.grade.dto.GradeRequestDto;
import com.grade.tracker.grade.dto.GradeResponseDto;
import com.grade.tracker.grade.service.GradeService;
import com.grade.tracker.shared.exception.InternalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.grade.tracker.shared.CommonConstants.*;

@RestController
@RequestMapping(GRADES)
public class GradeRestController {
    private final GradeService gradeService;

    public GradeRestController(final GradeService gradeService) {
        this.gradeService = gradeService;
    }
    @PostMapping(SAVE)
    public ResponseEntity<GradeResponseDto> save(final @RequestBody GradeRequestDto gradeRequestDto) throws InternalException {
        final var gradeResponseDto =gradeService.save(gradeRequestDto);
        return ResponseEntity.ok().body(gradeResponseDto);
    }

    @DeleteMapping(DELETE+PARAM_STUDENT_ID)
    public ResponseEntity<Void> deleteByStudent(final @PathVariable String studentId){
        gradeService.deleteByStudent(studentId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(UPDATE)
    public ResponseEntity<GradeResponseDto> update(final @RequestBody GradeRequestDto gradeRequestDto){
        final var gradeResponseDto = gradeService.update(gradeRequestDto);
        return ResponseEntity.ok().body(gradeResponseDto);
    }
    @GetMapping()
    public ResponseEntity<List<GradeResponseDto>> getAllByStudentAndSubject(final @RequestParam(required = false) Optional<String> subjectId , final @RequestParam String studentId ){
        final List<GradeResponseDto> gradeResponseDtos ;
        if (subjectId.isPresent())
            gradeResponseDtos=  gradeService.getAllBySubjectAndStudent(subjectId.get(), studentId);
        else
            gradeResponseDtos=  gradeService.getAllByStudent(studentId);
        return ResponseEntity.ok(gradeResponseDtos);
    }

}
