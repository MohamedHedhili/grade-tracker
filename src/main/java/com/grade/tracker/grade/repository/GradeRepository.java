package com.grade.tracker.grade.repository;

import com.grade.tracker.grade.entities.Grade;
import com.grade.tracker.person.entities.Student;
import com.grade.tracker.subject.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, String> {
    List<Grade> findAllBySubjectAndStudent(final Subject subject, final Student student );
    void deleteByStudent(final Student student);
    List<Grade> findAllByStudent(final Student student );
}