package com.deloitte.employeeService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.employeeService.domain.Employee;
import com.deloitte.employeeService.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployee(String employeeName) {
		return employeeRepository.findByEmployeeName(employeeName);
	}

	public List<Employee> getEmployee() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(int id) {
		employeeRepository.delete(id);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

}
