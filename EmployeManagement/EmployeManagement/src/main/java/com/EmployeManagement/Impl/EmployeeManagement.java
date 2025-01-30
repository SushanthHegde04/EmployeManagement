package com.EmployeManagement.Impl;

import java.util.List;

import com.EmployeManagement.Entity.Employee;

public interface EmployeeManagement {
	public List<Employee> getEmployee();
	public Employee addEmployee(Employee e);
	public Employee getEmployeeById(String  id);
	public Employee updateEmployee(Employee e);
	public String deleteEmployee(String id);

}
