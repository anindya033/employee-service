package com.crafter.employee_service.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crafter.employee_service.model.Employee;

@Repository
public class EmployeeRepo {
	private List<Employee> employees = new ArrayList<>();
	
	public Employee addEmplyee(Employee employee) {
		employees.add(employee);
		return employee;
	}
	
	public Employee findById(Long id) {
		 
		return employees.stream()
				.filter(data-> data.getId().equals( id))
				.findFirst()
				.orElseThrow();
	}
	
	public List<Employee> findAllEmployees(){
		return employees;
	}
	
	public List<Employee> findByDepartmentId(Long departmentId) {
		 
		return employees.stream()
				.filter(data-> data.getDepartmentId().equals(departmentId))
				.toList();
	}
}
