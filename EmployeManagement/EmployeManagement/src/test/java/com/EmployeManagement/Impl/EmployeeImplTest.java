package com.EmployeManagement.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.EmployeManagement.Entity.Employee;

public class EmployeeImplTest {

    private EmployeeManagementImpl employeeManagement;

    @BeforeEach
    public void setUp() {
        employeeManagement = new EmployeeManagementImpl();
    }

    @Test
    public void testGetEmployee() {
        List<Employee> employees = employeeManagement.getEmployee();
        assertEquals(3, employees.size());
    }

    @Test
    public void testAddEmployee() {
        Employee newEmployee = new Employee("E004", "Anna", "Taylor", "anna.taylor@example.com", "QA Engineer");
        employeeManagement.addEmployee(newEmployee);

        List<Employee> employees = employeeManagement.getEmployee();
        assertEquals(4, employees.size());
        assertEquals(newEmployee, employees.get(3));
    }
}
