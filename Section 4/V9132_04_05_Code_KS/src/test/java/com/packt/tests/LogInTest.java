package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class LogInTest extends BaseTest {
	
	@Test
	public void logInTest() {
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("Page opened");
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement logInButton = driver.findElement(By.tagName("button"));

		//driver.findElement(By.id("username")).sendKeys("tomsmith");
		username.sendKeys("tomsmith");
		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();

		//driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		password.sendKeys("SuperSecretPassword!");
		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();
		takeScreenshot("filled fields");

		//driver.findElement(By.tagName("button")).click();
		logInButton.click();
		takeScreenshot("click executed");

		//String message = driver.findElement(By.id("flash-messages")).getText();
		WebElement messageElement = driver.findElement(By.id("flash-messages"));
		String message = messageElement.getText();

		Assert.assertTrue(message.contains("You logged into a secure area!"), "Message doesn't contain expected text.");
		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();
	}
}
