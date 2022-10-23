package com.dojo.sessionattributes.repository;

import com.dojo.sessionattributes.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
