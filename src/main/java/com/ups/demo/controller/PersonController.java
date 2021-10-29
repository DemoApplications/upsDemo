package com.ups.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ups.demo.model.Person;
import com.ups.demo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired 
	PersonService personService;
	
	@GetMapping("/showAll")
	public List<Person> showAllPersons() {
		return personService.getAllPersons();
	}

	@PostMapping("/insert")
	public Person insertPerson(@RequestBody Person person) {
		return personService.insertPerson(person);
	}
}
