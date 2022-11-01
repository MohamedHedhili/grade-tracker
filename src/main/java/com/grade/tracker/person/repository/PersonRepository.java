package com.grade.tracker.person.repository;

import com.grade.tracker.person.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository <T extends Person> extends JpaRepository<T,String> {
}
