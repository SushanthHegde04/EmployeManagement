package com.EmployeManagement.Controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.EmployeManagement.Entity.Employee;
import com.EmployeManagement.Impl.EmployeeManagement;
import com.fasterxml.jackson.databind.ObjectMapper;
public class EmployeeControllerTest {
	   @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private EmployeeManagement employeeManagement;

	    private Employee employee1;
	    private Employee employee2;

	    @BeforeEach
	    public void setUp() {
	        employee1 = new Employee("E001", "John", "Doe", "john.doe@example.com", "Software Engineer");
	        employee2 = new Employee("E002", "Jane", "Smith", "jane.smith@example.com", "Product Manager");
	    }

	    @Test
	    public void testGetEmployees() throws Exception {
	        when(employeeManagement.getEmployee()).thenReturn(Arrays.asList(employee1, employee2));

	        mockMvc.perform(get("/employee"))
	                .andExpect(status().isOk())
	                .andExpect(content().json("[{'employee_id':'E001','first_name':'John','last_name':'Doe','email':'john.doe@example.com','title':'Software Engineer'},{'employee_id':'E002','first_name':'Jane','last_name':'Smith','email':'jane.smith@example.com','title':'Product Manager'}]"));
	    }

	    @Test
	    public void testAddEmployee() throws Exception {
	        Employee newEmployee = new Employee("E003", "Jim", "Brown", "jim.brown@example.com", "UX Designer");
	        when(employeeManagement.addEmployee(newEmployee)).thenReturn(newEmployee);

	        mockMvc.perform(post("/employees")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(newEmployee)))
	                .andExpect(status().isOk())
	                .andExpect(content().json("{'employee_id':'E003','first_name':'Jim','last_name':'Brown','email':'jim.brown@example.com','title':'UX Designer'}"));
	    }

	    private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
