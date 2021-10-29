package com.ups.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	private final Logger logger = LoggerFactory.getLogger(PersonControllerTest.class);
	
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void test_show_all() throws Exception {
    	String response = mockMvc.perform(get("/person/showAll")).andExpect(status().is(HttpStatus.OK.value()))
    			.andExpect(jsonPath("$", hasSize(3)))
    			.andExpect(jsonPath("$[0].firstName", equalTo("Pedro")))
                .andReturn().getResponse().getContentAsString();
    	logger.info("response: " + response);
    }
    
    @Test
    public void test_insert() throws Exception {
    	String response = mockMvc.perform(post("/person/insert").contentType(MediaType.APPLICATION_JSON).content("{\r\n" + 
    			"\"firstName\":\"Juana\",\"lastName\":\"Garcia\",\"phoneNumber\":\"449-999-99-99\"\r\n" + 
    			"}"))
    			
    			.andExpect(status().is(HttpStatus.OK.value()))
    			.andExpect(jsonPath("$.id", notNullValue()))
    			.andExpect(jsonPath("$.firstName", equalTo("Juana")))
                .andReturn().getResponse().getContentAsString();
    	logger.info("response: " + response);
    }    
}
