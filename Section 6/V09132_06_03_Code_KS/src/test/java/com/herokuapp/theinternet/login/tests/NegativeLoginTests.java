package com.herokuapp.theinternet.login.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;

public class NegativeLoginTests extends BaseTest {

	@Test(priority = 1)
	public void incorrectUsernameTest() {
		// Open Login page directly
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("Page opened");

		// LogIn page locators
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement logInButton = driver.findElement(By.tagName("button"));

		// fill up incorrect username and password
		username.sendKeys("incorrectUsername");
		password.sendKeys("SuperSecretPassword!");

		// push login button
		logInButton.click();
		System.out.println("Clicked log in with incorrect username");

		// wait for success message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));

		WebElement flashError = driver.findElement(By.id("flash"));
		String message = flashError.getText();

		Assert.assertTrue(message.contains("Your username is invalid!"), "Message doesn't contain expected text.");
	}

	@Test(priority = 2)
	public void incorrectPasswordTest() {
		// Open Login page directly
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("Page opened");

		// LogIn page locators
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement logInButton = driver.findElement(By.tagName("button"));

		// fill up username and incorrect password
		username.sendKeys("tomsmith");
		password.sendKeys("incorrectPassword");

		// push login button
		logInButton.click();
		System.out.println("Clicked log in with incorrect password");

		// wait for success message
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));

		WebElement flashError = driver.findElement(By.id("flash"));
		String message = flashError.getText();

		Assert.assertTrue(message.contains("Your password is invalid!"), "Message doesn't contain expected text.");
	}

}
