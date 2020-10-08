package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.out.println("Starting Student Repo setup");
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("Setup finished");

		StudentRepository repo = context.getBean(StudentRepository.class);
		Iterable<Student> students = repo.findAll();
		for (Student s: students) {
			System.out.println(s);
		}

//		Student student = new Student(8, "Jill", "Matthews", "Law", "jm@my.com", "2");
//		repo.save(student);

//		System.out.println("Check book with Student with id 7 is in database");
//		Optional<Student> optionalStudent = repo.findById(7);
//		System.out.print(optionalStudent);
//		Student s1 = optionalStudent.orElse(null);
//		System.out.println(s1);
//
//		System.out.println("Delete Student just Added");
//		repo.deleteById(7);

		System.out.println("Done");
	}
}