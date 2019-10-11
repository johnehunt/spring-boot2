package com.jjh.beans;

import java.util.Random;

public class DataServiceImpl implements DataService {
	
	private Random random;
	
	public DataServiceImpl() {
		random = new Random();
	}

	@Override
	public int getData() {
		int result = this.random.nextInt(100);
		return result;
	}

}
