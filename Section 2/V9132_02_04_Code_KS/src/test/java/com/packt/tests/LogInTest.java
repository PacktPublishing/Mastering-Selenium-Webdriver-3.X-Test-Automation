package com.packt.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class LogInTest extends BaseTest {

	@Test
	public void logInTest() {
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("Page opened");
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.tagName("button")).click();
		
		String message = driver.findElement(By.id("flash-messages")).getText();
		Assert.assertTrue(message.contains("You logged into a secure area!"), "Message doesn't contain expected text.");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
