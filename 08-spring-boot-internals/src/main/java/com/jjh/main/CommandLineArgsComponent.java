package com.jjh.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class CommandLineArgsComponent {

	@Autowired
	public CommandLineArgsComponent(ApplicationArguments args) {
		boolean enable = args.containsOption("enable");
		System.out.println("App is enabled: " + enable);

		List<String> nonOptionArgs = args.getNonOptionArgs();
		for (String option : nonOptionArgs)
			System.out.println(option);

	}

}
