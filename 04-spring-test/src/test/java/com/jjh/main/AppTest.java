package com.jjh.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	ApplicationContext context;

	@Test
	public void contextLoads() {
		assertNotNull(context);
	}
	
	@Test
	public void checkAllBeansLoaded() {
		int totalbeans = this.context.getBeanDefinitionCount();
		assertEquals("There should be 26 beans loaded", 26, totalbeans);
	}

}
