package com.yrd.cache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yrd.cache.model.Employee;
import com.yrd.cache.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee createEmployee(Employee emp) {
		
	return	employeeRepository.save(emp);
		
	}

	@Cacheable(cacheNames = {"employeeCache"})
	public List<Employee> findEmplyees() {
		
		System.out.println("Hit DB 1 st time:::::{getAll}::::::::::::");
		return employeeRepository.findAll();

	}
	@Cacheable(value  = "employeeCache",key="#id")
	public Optional<Employee> findEmplyee(int id) {
		System.out.println("Hit DB 1 st time::::for {id}:::::::::::::");
		return employeeRepository.findById(id);
	}


	@CacheEvict(value  = "employeeCache")
	public void deleteEmplyee(int id) {

		employeeRepository.deleteById(id);
	}

}
