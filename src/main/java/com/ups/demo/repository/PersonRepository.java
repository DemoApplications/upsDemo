package com.ups.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ups.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
