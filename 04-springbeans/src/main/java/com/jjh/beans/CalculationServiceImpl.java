package com.jjh.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CalculationService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CalculationServiceImpl implements CalculationService {
	private String prefix = ">";

	public CalculationServiceImpl() {
		System.out.println("CalculationServiceImpl.<cons>");
	}

	public void setPrefix(String prefix) {
		System.out.println("CalculationServiceImpl.setPrefix");
		this.prefix = prefix;
	}

	public String calc(String operation, double x, double y) {
		System.out.println("CalculationServiceImpl.calc: " + operation + " " + x + ", " + y);
		double result = 0.0;
		switch (operation) {
		case "+":
			result = x + y;
			break;
		case "-":
			result = x - y;
			break;
		}
		return prefix + result;
	}

}
