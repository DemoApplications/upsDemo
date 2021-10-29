package com.ups.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ups.demo.model.Person;
import com.ups.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired 
	PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	public Person insertPerson(Person person) {
	    personRepository.save(person);
	    return person;
	}
}
