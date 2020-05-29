package com.yrd.cache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yrd.cache.model.Employee;
//import javax.validation.Valid;
import com.yrd.cache.service.EmployeeService;

@RestController
@RequestMapping("/cache-api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value ="/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);

	}

	@GetMapping(value="/getEmployees",produces = "application/json; charset=UTF-8")
	public List<Employee> getallEmployees() {
		return employeeService.findEmplyees();

	}

	@GetMapping(value="/getEmployee/{id}")
	public Optional<Employee> getallEmployeeByid(@PathVariable int id) {
		return employeeService.findEmplyee(id);

	}

	@DeleteMapping(value="/deleteEmployee/{id}")

	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmplyee(id);

	}
}
