package com.jjh.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("welcome")
public class WelcomeController {

	// http://localhost:8080/welcome/hello
	
	@RequestMapping("hello")
	public String sayhello(Model model) throws Exception {
		System.out.println("WelcomeController.hello()");
		model.addAttribute("message", "John - " + new Date());
		return "greeting";
	}

	// use http://localhost:8080/welcome/help
	
	@RequestMapping("help")
	public String getHelp() {
		System.out.println("WelcomeController.help()");
		return "info";
	}
}
