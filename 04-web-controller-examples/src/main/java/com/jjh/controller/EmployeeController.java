package com.jjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.jjh.domain.EmployeeForm;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error").setViewName("error");
    }
	
	// http://localhost:8080/employees
	
	@RequestMapping
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("employee");
		mav.addObject("message", "getAllEmployees");
		// application code
		return mav;
	}

	// http://localhost:8080/employees/add/1/John
	
	@RequestMapping("add/{id}/{name}")
	public String addEmployee(Model model, @PathVariable("id") String id, @PathVariable String name) {
		System.out.println("addEmployee: " + id + "' " + name);
		model.addAttribute("message", "addEmployee(" + id + ", " + name + ")");
		return "employee";
	}
	
	// http://localhost:8080/employees/new?id=2
	
	@RequestMapping("new")
	public String addEmployeeByPath(ModelMap map, @RequestParam String id) {
		// Can have a default @RequestParam(defaultValue = "5") int total
		System.out.println("addEmployeeByPath: " + id);
		map.addAttribute("message", "addEmployeeByPath(" + id + ")");
		return "employee";
	}
	
	@RequestMapping(value ="/list", method = RequestMethod.GET, headers="Accept=application/text")
	public String employees(Model model) {
		System.out.println("employees()");
		model.addAttribute("message", "employees()");
		return "employee";
	}
	
	// Form Example
	// Display Form page - could populate form with default values

	@RequestMapping(value="add")
	public String addEmployeeForm(Model model) {
		model.addAttribute("employeeForm", new EmployeeForm());
		System.out.println("addEmployeeForm");
		return "new_employee";
	}
	
	@RequestMapping(value="add", method =  RequestMethod.POST)
	public String addEmployee(EmployeeForm form) {
		System.out.println("addEmployee " + form);
		return "employee";
	}
	
	// http://localhost:8080/employees/remove?id=1
	// http://localhost:8080/employees/delete?id=1

	@RequestMapping(value = { "remove", "delete" })
	public String removeEmployee(@RequestParam("id") String employeeId) {
		System.out.println("removeEmployee(" + employeeId + ")");
		return "employee";
	}
	
	// http://localhost:8080/employees/hello
	
	@RequestMapping("/hello")
	@ResponseBody
	String hello() {
	    return "<h2>Hello World!</h2>";
	}
	
	// Called before any request handler methods - so provides a default message into the model
	@ModelAttribute("message")
	String getMessage() {
		return "default message";
	}
	
}
