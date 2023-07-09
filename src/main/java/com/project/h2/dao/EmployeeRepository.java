package com.project.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.h2.model.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByDept(String dept);
	
	@Transactional
	@Modifying
	@Query("update Employee e set e.salary = ?1 where e.name = ?2") 
	int updateSalary(double salary, String name);


}
