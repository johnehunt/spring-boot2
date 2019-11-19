package com.jjh.domain;

public class EmployeeImpl implements Employee {

	private String name;
	private String employeeId;

	public EmployeeImpl() {
	}

	public EmployeeImpl(String employeeId, String name) {
		this.employeeId = employeeId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return employeeId;
	}

	public void setId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String toString() {
		return name + ": " + employeeId;
	}
}
