package com.jjh.beans;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jjh.main.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class} )
public class CalculcatorServiceImplTest {
	
	public CalculcatorServiceImplTest() {}
	
	@Autowired
	private CalculatorService calculator;
	
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("setUpBeforeClass");
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownAfterClass");
    }

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("In setup");
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("In tearDown");
	}

	@Test
	public void add() {
		calculator.add(1);
		calculator.add(1);
		Assertions.assertEquals(2, calculator.value(), "Result of add into 1 + 1 should be 2");
	}

	@Test
	public void clear() {
		calculator.add(1);
		calculator.add(1);
		calculator.clear();
		Assertions.assertEquals(0.0, calculator.value(), "Clear should give Zero");
	}

	@Disabled("not ready yet")
	@Test
	public void subtract() {
		calculator.add(2);
		calculator.subtract(5);
		Assertions.assertEquals(10.0, calculator.value(), "Testing result of subtraction");
	}

}
