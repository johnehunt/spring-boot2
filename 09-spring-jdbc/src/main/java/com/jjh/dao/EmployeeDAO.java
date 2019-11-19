package com.jjh.dao;

import java.util.List;

import com.jjh.domain.Employee;

public interface EmployeeDAO {

	List<Employee> getEmployees();
	
	int addEmployee(Employee e);
	
	List<Employee> getAltEmployees();
	
}
