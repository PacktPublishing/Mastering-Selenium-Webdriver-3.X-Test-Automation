package com.packt.tests;

import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class LogInTest extends BaseTest {
	
	@Test
	public void logInTest() {
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("Page opened");
	}
}
