package com.yrd.cache;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.yrd.cache.model.Employee;
import com.yrd.cache.repository.EmployeeRepository;

@SpringBootApplication
@EnableCaching
public class HazelCastSpringBootCacheApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@PostConstruct
//	public void initUsers() {
//
//		List<Employee> employees = Stream.of(new Employee(101, "Yash", "Home"), new Employee(102, "Dhruv", "DpsBlb"),
//				new Employee(101, "Ritu", "Home-Boss")).collect(Collectors.toList());
//
//		employeeRepository.saveAll(employees);
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(HazelCastSpringBootCacheApplication.class, args);
	}

}
