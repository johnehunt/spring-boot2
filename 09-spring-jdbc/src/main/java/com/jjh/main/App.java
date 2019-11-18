package com.jjh.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.jjh.dao.EmployeeDAO;
import com.jjh.dao.EmployeeDAO2;
import com.jjh.domain.Employee;
import com.jjh.domain.EmployeeImpl;

@SpringBootApplication
@PropertySource("classpath:bean.properties")
@ImportResource("classpath*:bean-context.xml")
public class App {
	public static void main(String[] args) {

		System.out.println("Main - obtaining Application Context");
		ApplicationContext context = SpringApplication.run(App.class, args);
		
		EmployeeDAO dao = context.getBean("employeeDao", EmployeeDAO.class);
		try {
			List<Employee> employees = dao.getEmployees();
			employees.forEach((Employee e) -> System.out.println(e));

//			List<Employee> employees = dao.getAltEmployees();
//			employees.forEach((Employee e) -> System.out.println(e));
			
			
//			EmployeeDAO2 dao2 = context.getBean("employeeDao2", EmployeeDAO2.class);
//			System.out.println("Inserting a new employee");
//			Employee e = new EmployeeImpl("5", "James");
//			dao2.addEmployee(e);
//			
//			Employee [] employees = new Employee[] {new EmployeeImpl("6", "Joselyn") };
//			dao2.addAllEmployees(employees);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
	}
}
