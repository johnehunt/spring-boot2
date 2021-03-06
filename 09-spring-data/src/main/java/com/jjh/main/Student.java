package com.jjh.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name")  // The default so unnecessary
	private String name;
	private String surname;
	private String subject;
	private String email;
	private String year;
	
	public Student() { } // Required by JPA
	
	public Student(int id, String name, String surname, String subject, String email, String year) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.subject = subject;
		this.email = email;
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", subject='" + subject + '\'' +
				", email='" + email + '\'' +
				", year='" + year + '\'' +
				'}';
	}
}
