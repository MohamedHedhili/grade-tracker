package com.grade.tracker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradeTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradeTrackerApplication.class, args);
    }
    /*
    @Bean
    CommandLineRunner start(final SubjectService subjectService, final SchoolClassService schoolClassService ,
                            final GradeService gradeService , final StudentService studentService , final TeacherService teacherService){
        return args ->{
       final var subjectRequestDto1 = SubjectRequestDto.builder().name("Mathematics").build();
           final var subjectRequestDto2 = SubjectRequestDto.builder().name("Algorithmic").build();
           final var subjectResponseDto1 =  subjectService.save(subjectRequestDto1);
           final var subjectResponseDto2 =  subjectService.save(subjectRequestDto2);
           final var teacherRequestDto1 = TeacherRequestDto
                    .builder().firstName("Arnaud").lastName("LOUIS").gender(Gender.M)
                    .subjectRequestDto(SubjectRequestDto.builder().id(subjectResponseDto1.getId()).build()).build();
           final var teacherRequestDto2 = TeacherRequestDto
                    .builder().firstName("Pascal").lastName("JULLIEN").gender(Gender.M)
                    .subjectRequestDto(SubjectRequestDto.builder().id(subjectResponseDto2.getId()).build()).build();
           final var teacherResponseDto1 =  teacherService.save(teacherRequestDto1);
           final var teacherResponseDto2 =  teacherService.save(teacherRequestDto2);

           final var schoolClassRequestDto1 = SchoolClassRequestDto
                    .builder().levelName("5 éme")
                    .teacherRequestDto(TeacherRequestDto.builder().id(teacherResponseDto1.getId()).build()).build();
           final var schoolClassRequestDto2 = SchoolClassRequestDto
                    .builder().levelName("4 éme")
                    .teacherRequestDto(TeacherRequestDto.builder().id(teacherResponseDto2.getId()).build()).build();
           final var schoolClassResponseDto1 =  schoolClassService.save(schoolClassRequestDto1);
           final var schoolClassResponseDto2 =  schoolClassService.save(schoolClassRequestDto2);
           final var studentRequestDto1 = StudentRequestDto
                    .builder().firstName("Luis").lastName("LAGARCE").gender(Gender.M)
                    .schoolClassRequestDto(SchoolClassRequestDto.builder().id(schoolClassResponseDto1.getId()).build()).build();
           final var studentRequestDto2 = StudentRequestDto
                    .builder().firstName("Pierre").lastName("CORNILLE").gender(Gender.M)
                    .schoolClassRequestDto(SchoolClassRequestDto.builder().id(schoolClassResponseDto1.getId()).build()).build();
           final var studentRequestDto3 = StudentRequestDto
                    .builder().firstName("Alex").lastName("EVRA").gender(Gender.M)
                    .schoolClassRequestDto(SchoolClassRequestDto.builder().id(schoolClassResponseDto2.getId()).build()).build();
           final var studentRequestDto4 = StudentRequestDto
                    .builder().firstName("Sophie").lastName("DELARUE").gender(Gender.F)
                    .schoolClassRequestDto(SchoolClassRequestDto.builder().id(schoolClassResponseDto2.getId()).build()).build();
           final var studentResponseDto1 = studentService.save(studentRequestDto1);
           final var studentResponseDto2 = studentService.save(studentRequestDto2);
           final var studentResponseDto3 = studentService.save(studentRequestDto3);
           final var studentResponseDto4 = studentService.save(studentRequestDto4);
           final var gradeRequestDto1 = GradeRequestDto
                    .builder().value(10)
                    .studentRequestDto(StudentRequestDto.builder().id(studentResponseDto1.getId()).build())
                    .subjectRequestDto(SubjectRequestDto.builder().id(subjectResponseDto1.getId()).build())
                    .build();
           final var gradeRequestDto2 = GradeRequestDto
                    .builder().value(13)
                    .studentRequestDto(StudentRequestDto.builder().id(studentResponseDto1.getId()).build())
                    .subjectRequestDto(SubjectRequestDto.builder().id(subjectResponseDto2.getId()).build())
                    .build();
           final var gradeResponseDto1 = gradeService.save(gradeRequestDto1);

           final var gradeResponseDto2 = gradeService.save(gradeRequestDto2);
        };
    }**/

}
