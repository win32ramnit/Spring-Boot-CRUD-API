package com.manish.sms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manish.sms.entities.Address;
import com.manish.sms.entities.Student;
import com.manish.sms.services.StudentService;

@WebMvcTest
public class StudentControllerTests {
/*
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void givenStudentObject_whenCreateStudent_thenReturnSavedStudentId() throws Exception {
		// given - precondition
		Student student = new Student();
		student.setId(1);
		student.setName("Bob");
		student.setCourse("MCA");
		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setId(1);
		address.setFlatno("A-11");
		address.setStreet("11");
		address.setState("AA");
		address.setDistrict("A");
		address.setPin("11000011");
		address.setContact("1234567890");
		addresses.add(address);
		student.setAddresses(addresses);

		BDDMockito.given(studentService.save(ArgumentMatchers.any(Student.class)))
				.willAnswer((invocation) -> invocation.getArgument(0));
		
		// when - action or behavior that we are going test
		ResultActions response = mockMvc.perform(post("/sms/api/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(student)));
		
		// then - verify the result or output using assert statements
		response.andExpect(MockMvcResultMatchers.status().isCreated())
			//.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(student.getId())))
			//.andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(student.getName())))
			//.andExpect(MockMvcResultMatchers.jsonPath("$.course", CoreMatchers.is(student.getCourse())))
		
		
		;
	}
*/
}
