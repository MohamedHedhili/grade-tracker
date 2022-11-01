package com.grade.tracker.subject.rest;

import com.grade.tracker.subject.dto.SubjectRequestDto;
import com.grade.tracker.subject.dto.SubjectResponseDto;
import com.grade.tracker.subject.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.grade.tracker.shared.CommonConstants.*;

@RestController
@RequestMapping(SUBJECTS)
public class SubjectRestController {
    private final SubjectService subjectService;

    public SubjectRestController(final SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @PostMapping(SAVE)
    public ResponseEntity<SubjectResponseDto> save(final @RequestBody SubjectRequestDto subjectRequestDto)  {
        final var subjectResponseDto =subjectService.save(subjectRequestDto);
        return ResponseEntity.ok().body(subjectResponseDto);
    }


    @GetMapping()
    public ResponseEntity<List<SubjectResponseDto>> getAll( ){
        final var subjectResponseDtos = subjectService.findAll();
        return ResponseEntity.ok(subjectResponseDtos);
    }
}
