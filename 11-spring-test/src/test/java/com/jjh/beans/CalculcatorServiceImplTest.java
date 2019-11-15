package com.jjh.beans;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jjh.main.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class} )
public class CalculcatorServiceImplTest {
	
	public CalculcatorServiceImplTest() {}
	
	@Autowired
	private CalculatorService calculator;

	private static final double DELTA = 1e-15;

	@Before
	public void setUp() throws Exception {
		System.out.println("In setup");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("In tearDown");
	}

	@Test
	public void add() {
		calculator.add(1);
		calculator.add(1);
		assertEquals("Result fo add into 1 + 1 shoudl be 2", 2, calculator.value(), DELTA);
	}

	@Test
	public void clear() {
		calculator.add(1);
		calculator.add(1);
		calculator.clear();
		assertEquals("Clear shoudl give Zero", 0.0, calculator.value(), DELTA);
	}

	@Ignore("not ready yet")
	@Test
	public void subtract() {
		calculator.add(2);
		calculator.subtract(5);
		assertEquals("Testing reuslt of subtraction", 10.0, calculator.value(), DELTA);
	}

}
