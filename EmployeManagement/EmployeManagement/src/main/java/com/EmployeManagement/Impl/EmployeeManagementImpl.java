package com.EmployeManagement.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.EmployeManagement.Entity.Employee;

@Service
public class EmployeeManagementImpl  implements EmployeeManagement{

	List<Employee> emp;
	public EmployeeManagementImpl()
	{
		emp=new ArrayList<>();
		emp.add(new Employee("E001", "John", "Doe", "john.doe@example.com", "Software Engineer"));
		 emp.add(new Employee("E002", "Jane", "Smith", "jane.smith@example.com", "Product Manager"));
	        emp.add(new Employee("E003", "Jim", "Brown", "jim.brown@example.com", "UX Designer"));
	}
	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return emp;
	}
	@Override
	public Employee addEmployee(Employee e) {
		emp.add(e);
		// TODO Auto-generated method stub
		return e;
	}
	@Override
	public Employee getEmployeeById(String id) {
	    for (Employee e : emp) {
	        if (e.getEmployee_id().equals(id)) { // Assuming Employee class has a getId() method
	            return e;
	        }
	    }
	    return null; // Return null if no employee is found with the given id
	}
	@Override
	public Employee updateEmployee(Employee e) {
	    for (int i = 0; i < emp.size(); i++) {
	        if (emp.get(i).getEmployee_id().equals(e.getEmployee_id())) { // Check for matching ID
	            emp.set(i, e); // Replace the existing employee with the updated one
	            return e;
	        }
	    }
	    
	    return null; // Return null if no employee is found with the given ID
	}
	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		 for (Employee e : emp) {
		        if (e.getEmployee_id().equals(id)) { // Assuming Employee class has a getId() method
		            emp.remove(e);
		            return "Employee "+id+" deleted";
		        }
		    }
	return "Employee with "+id+" not found";
		
		
	}



}
