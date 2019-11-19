package com.jjh.domain;

import java.util.List;

public class DepartmentImpl implements Department {
	
	private String name;
	private List<Employee> employees;
	
	public DepartmentImpl() { }
	
	public DepartmentImpl(String name) { 
		this.name = name; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
