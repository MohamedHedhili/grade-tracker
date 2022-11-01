package com.grade.tracker.schoolclass.rest;

import com.grade.tracker.schoolclass.dto.SchoolClassRequestDto;
import com.grade.tracker.schoolclass.dto.SchoolClassResponseDto;
import com.grade.tracker.schoolclass.service.SchoolClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.grade.tracker.shared.CommonConstants.SAVE;
import static com.grade.tracker.shared.CommonConstants.SCHOOL_CLASS;

@RestController
@RequestMapping(SCHOOL_CLASS)
public class SchoolClassRestController {
    private final SchoolClassService schoolClassService;

    public SchoolClassRestController(final SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }
    @PostMapping(SAVE)
    public ResponseEntity<SchoolClassResponseDto> save(final @RequestBody SchoolClassRequestDto schoolClassRequestDto)  {
        final var schoolClassResponseDto =schoolClassService.save(schoolClassRequestDto);
        return ResponseEntity.ok().body(schoolClassResponseDto);
    }


    @GetMapping()
    public ResponseEntity<List<SchoolClassResponseDto>> getAll( ){
        final var schoolClassResponseDtos = schoolClassService.findAll();
        return ResponseEntity.ok(schoolClassResponseDtos);
    }
}
