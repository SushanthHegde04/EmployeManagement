package com.EmployeManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeManagement.Entity.Employee;
import com.EmployeManagement.Impl.EmployeeManagement;
@RestController
@RequestMapping("https")
public class empController {
	@Autowired
	EmployeeManagement empmanagement;
	@GetMapping("/employee")
	public List<Employee> getEmp()
	{
		return empmanagement.getEmployee();
	}
	@GetMapping("/employee/{id}")
	public Employee getempbyid(@PathVariable String id)
	{
		return empmanagement.getEmployeeById(id);
	}
    @PostMapping("/add")
    public Employee addEmp(@RequestBody Employee e)
    {
    	return empmanagement.addEmployee(e);
    }
    @PutMapping("/update")
    public Employee updateEmp(@RequestBody Employee e)
    {
    	return empmanagement.addEmployee(e);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable String id)
    {
    	return empmanagement.deleteEmployee(id);
    }
    
}
