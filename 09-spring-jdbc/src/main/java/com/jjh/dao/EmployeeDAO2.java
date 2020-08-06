// Provides an example of using the SimpleJDBCInsert template
// and the NamedParameterJDBC Template
package com.jjh.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.jjh.domain.Employee;

@Component("employeeDao2")
public class EmployeeDAO2 {

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public int addEmployee(Employee emp) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", emp.getId());
		parameters.put("name", emp.getName());
		return simpleJdbcInsert.withTableName("EMPLOYEE").execute(parameters);
	}
	
	public int[] addAllEmployees(Employee [] employees) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(employees);
		int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(
		    "INSERT INTO EMPLOYEE VALUES (:id, :name)", batch);
		return updateCounts;
	}

}
