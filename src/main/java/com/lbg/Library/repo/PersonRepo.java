package com.lbg.Library.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.Library.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
