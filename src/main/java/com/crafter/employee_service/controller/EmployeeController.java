package com.crafter.employee_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crafter.employee_service.model.Employee;
import com.crafter.employee_service.repo.EmployeeRepo;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepo repo;
	
	@PostMapping(value="/add")
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee added : {}", employee);
		return repo.addEmplyee(employee);
	}
	
	@GetMapping(value="/getAllEmployees")
	public List<Employee> getAllDepartments(){
		LOGGER.info("Employee Find all");
		return repo.findAllEmployees();
	}
	
	@GetMapping(value="/getEmployeeById")
	public Employee findById(@RequestParam Long id){
		LOGGER.info("Employee Find by id");
		return repo.findById(id);
	}
	
	@GetMapping(value="/department/getEmployeeByDepartmentId/{departmentId}")
	public List<Employee> getEmployeeByDepartmentId(@PathVariable Long departmentId){
		LOGGER.info("Employee Find by department id -> "+departmentId);
		return repo.findByDepartmentId(departmentId);
	}
}
