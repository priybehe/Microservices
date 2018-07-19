package com.deloitte.employeeService.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.employeeService.domain.Employee;
import com.deloitte.employeeService.service.EmployeeService;

@RestController
@RequestMapping("/employeeService")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmployee/{employeeName}")
	public Employee getEmployee(@PathVariable("employeeName") final String employeeName) {
		return employeeService.getEmployee(employeeName);
	}

	@RequestMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployee();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee added successfully";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted Successfully";

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateEmployee")
	public String updateTopic(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "Employee Updated Successfully";

	}

}
