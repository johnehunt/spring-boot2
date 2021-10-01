package com.jjh.spring.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="employee")
public class Employee {

	@Column(name="name")
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	public String toString() {
		return name + ", " + id;
	}
}
