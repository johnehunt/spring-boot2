package com.jjh.spring.jpa.dao;

import com.jjh.spring.employee.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee findById(int id);

    Employee save(Employee emp);

    Employee update(Employee emp);

    void delete(Employee emp);

    void refresh(Employee emp);

    List<Employee> findAll();

}
