package com.jjh.beans;

import org.springframework.stereotype.Component;

@Component
public class CalculcatorServiceImpl implements CalculatorService {
	
	private double memory = 0.0;
	
	public CalculcatorServiceImpl() {
		System.out.println("CalculcatorServiceImpl.<cons>()");
	}

	public double add(double d) {
		return memory += d;
	}

	public double subtract(double d) {
		return memory -= d;
	}

	public void clear() {
		memory = 0.0;
	}
	
	public double value() {
		return memory;
	}

}
