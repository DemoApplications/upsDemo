package com.ups.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.ups.demo.model.Person;
import com.ups.demo.service.PersonService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonServiceTest {

    @MockBean
    PersonService personService;
    
    List<Person> personList = new ArrayList<>();
    
    @BeforeAll
    public void setUp() {
    	personList.add(new Person(1, "German", "Robles", "449-178-23-21"));
    	personList.add(new Person(2, "Luisa", "Beltran", "449-555-67-90"));
    	personList.add(new Person(3, "German", "Robles", "449-279-32-93"));
    }
    
	
	@Test
	public void test_get_all_persons() {
		when(personService.getAllPersons()).thenReturn(personList);
		assertNotNull(personService.getAllPersons());
		assertEquals(3, personService.getAllPersons().size());
	}

}
