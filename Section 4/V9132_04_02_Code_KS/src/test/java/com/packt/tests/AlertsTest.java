package com.packt.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class AlertsTest extends BaseTest {

	@Test(priority=1)
	public void jSAlertButtonTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		System.out.println("Page opened!");

		// Clicking alert button
		WebElement jSAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		jSAlertButton.click();

		// Wait for alert
		WebDriverWait fiveSecondsWait = new WebDriverWait(driver, 5);
		fiveSecondsWait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);

		// Verification 1: Correct alert opened
		Assert.assertTrue(alertText.equals("I am a JS Alert"), "Alert text is not expected!");

		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();

		// Accept alert
		alert.accept();

		// Verification 2: Correct result text
		WebDriverWait threeSecondsWait = new WebDriverWait(driver, 3);
		Assert.assertTrue(threeSecondsWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"),
				"You successfuly clicked an alert")), "Result text is not expected!");
		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();
	}


	@Test(priority=2)
	public void jSAlertConfirmTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		System.out.println("Page opened!");

		// Clicking alert button
		WebElement jSAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		jSAlertButton.click();

		// Wait for alert
		WebDriverWait fiveSecondsWait = new WebDriverWait(driver, 5);
		fiveSecondsWait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);

		// Verification 1: Correct alert opened
		Assert.assertTrue(alertText.equals("I am a JS Confirm"), "Alert text is not expected!");

		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();

		// Accept alert
		alert.accept();

		// Verification 2: Correct result text
		WebDriverWait threeSecondsWait = new WebDriverWait(driver, 3);
		Assert.assertTrue(threeSecondsWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"),
				"You clicked: Ok")), "Result text is not expected!");

		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();
	}


	@Test(priority=3)
	public void jSAlertCancelTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		System.out.println("Page opened!");

		// Clicking alert button
		WebElement jSAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		jSAlertButton.click();

		// Wait for alert
		WebDriverWait fiveSecondsWait = new WebDriverWait(driver, 5);
		fiveSecondsWait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);

		// Verification 1: Correct alert opened
		Assert.assertTrue(alertText.equals("I am a JS Confirm"), "Alert text is not expected!");

		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();

		// Cancel alert
		alert.dismiss();

		// Verification 2: Correct result text
		WebDriverWait threeSecondsWait = new WebDriverWait(driver, 3);
		Assert.assertTrue(threeSecondsWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"),
				"You clicked: Cancel")), "Result text is not expected!");

		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();
	}


	@Test(priority=4)
	public void jSAlertPromptTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		System.out.println("Page opened!");

		// Clicking alert button
		WebElement jSAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		jSAlertButton.click();

		// Wait for alert
		WebDriverWait fiveSecondsWait = new WebDriverWait(driver, 5);
		fiveSecondsWait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);

		// Verification 1: Correct alert opened
		Assert.assertTrue(alertText.equals("I am a JS prompt"), "Alert text is not expected!");

		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();

		// Type text into alert
		alert.sendKeys("Hello, world!");

		// Accept alert
		alert.accept();

		// Verification 2: Correct result text
		WebDriverWait threeSecondsWait = new WebDriverWait(driver, 3);
		Assert.assertTrue(threeSecondsWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"),
				"You entered: Hello, world!")), "Result text is not expected!");

		// SLEEP FOR STUDENTS TO SEE SCREEN
		sleep();
	}


	// STATIC SLEEP FOR STUDENTS TO SEE TEST EXECUTION
	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
