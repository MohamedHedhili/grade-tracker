package com.grade.tracker.person.repository;


import com.grade.tracker.person.entities.Student;
import com.grade.tracker.schoolclass.entities.SchoolClass;

import java.util.List;


public interface StudentRepository extends PersonRepository<Student>{
    List<Student> findAllBySchoolClass(final SchoolClass schoolClass);
}

