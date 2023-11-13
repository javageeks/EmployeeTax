package com.imaginnovate.employees.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.imaginnovate.employees.model.EmployeeDTO;
import com.imaginnovate.employees.service.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.imaginnovate.employees")
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
    @Mock
    private EmployeeService employeeService;
    
	//@Test
	public void testCreateEmployee()throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/employees")
				.content(asJsonString(EmployeeDTO.builder().id(1).firstName("FirstName1").lastName("LastName1")
						.emailId("email@gmail.com").phone(Arrays.asList(1232244L, 124234234L)).salary(500000)
						.doj(LocalDate.of(2023, 05, 13)).build())))
				.andExpect(status().isCreated());
	}

	//@Test
	public void testGetEmployeeTax() throws Exception {
		mockMvc.perform(get("/emptax/1")
			    .contentType("application/json"))
			    .andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objectMapper.registerModule(new JavaTimeModule());
	        return objectMapper.writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
