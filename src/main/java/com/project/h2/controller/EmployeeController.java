package com.project.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.h2.dao.EmployeeRepository;
import com.project.h2.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository eRepository;
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		eRepository.save(employee);
		return "saveEmployee...";
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAll() {
		return eRepository.findAll();
	}
	
	@GetMapping("/getEmployee/{dept}")
	public List<Employee> getEmployeesByDept(@PathVariable String dept) {
		return eRepository.findByDept(dept);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		eRepository.deleteAll();
		return "Data Deleted...";
	}
	
	
	@PostMapping("/updateEmployee")
	public String updateByName(@RequestParam double salary, @RequestParam String name) {
		eRepository.updateSalary(salary, name);
		return "Data Updated...";
	}
	
	
}
