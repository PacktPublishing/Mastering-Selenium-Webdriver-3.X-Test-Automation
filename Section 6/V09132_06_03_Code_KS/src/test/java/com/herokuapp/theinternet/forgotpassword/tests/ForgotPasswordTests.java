package com.herokuapp.theinternet.forgotpassword.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;

public class ForgotPasswordTests extends BaseTest {

	@Test(priority = 1)
	public void logInTest() {
		// Open Home Page
		driver.get("http://the-internet.herokuapp.com");
		System.out.println("Page opened");

		// Open Forgot Password page
		WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
		forgotPasswordLink.click();

		// Wait for Forgot Password page to load
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

		// Forgot Password page locators
		WebElement email = driver.findElement(By.id("email"));
		WebElement retrievePasswordButton = driver.findElement(By.tagName("button"));

		// fill up username and password
		email.sendKeys("user@email.com");
		System.out.println("Filled email field");

		// push retrieve Password button
		retrievePasswordButton.click();

		// wait for success message
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash-messages")));

		WebElement emailSentMessageElement = driver.findElement(By.id("content"));
		String message = emailSentMessageElement.getText();

		Assert.assertTrue(message.contains("Your e-mail's been sent!"), "Message doesn't contain expected text.");
	}

}
