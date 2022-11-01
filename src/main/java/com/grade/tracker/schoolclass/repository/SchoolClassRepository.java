package com.grade.tracker.schoolclass.repository;

import com.grade.tracker.schoolclass.entities.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, String> {
}