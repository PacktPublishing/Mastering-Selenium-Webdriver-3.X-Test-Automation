package com.herokuapp.theinternet.login.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;

public class PositiveLoginTests extends BaseTest {

	@Test(priority = 1)
	public void logInTest() {
		// Open Home Page
		driver.get("http://the-internet.herokuapp.com");
		System.out.println("Page opened");

		// Open Login page
		WebElement formAuthenticationLink = driver.findElement(By.linkText("Form Authentication"));
		formAuthenticationLink.click();

		// Wait for login page to load
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

		// LogIn page locators
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement logInButton = driver.findElement(By.tagName("button"));

		// fill up username and password
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		System.out.println("Filled username and password");

		// push login button
		logInButton.click();

		// wait for success message
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));

		WebElement messageElement = driver.findElement(By.id("flash-messages"));
		String message = messageElement.getText();

		Assert.assertTrue(message.contains("You logged into a secure area!"), "Message doesn't contain expected text.");
	}

}
