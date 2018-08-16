package com.packt.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class RegistrationTest extends BaseTest {

	@Test
	public void registrationTest() {
		driver.get("http://demoqa.com/registration/");

		WebElement firstName = driver.findElement(By.cssSelector("#name_3_firstname"));
		WebElement lastName = driver.findElement(By.id("name_3_lastname"));
		WebElement phoneNumber = driver.findElement(By.name("phone_9"));

		WebElement username = driver.findElement(By.id("username"));
		WebElement email = driver.findElement(By.name("e_mail"));

		WebElement password = driver.findElement(By.xpath("//input[@id='password_2']"));
		WebElement passwordConfirmation = driver
				.findElement(By.xpath("//input[contains(@class,'equals[password_2]')]"));
		WebElement submitButton = driver.findElement(By.xpath("//*[@value='Submit']"));

		firstName.sendKeys("Dmitry");
		lastName.sendKeys("Webdriver");
		phoneNumber.sendKeys("4445556677");

		username.sendKeys("dmitryWebdriver" + getTime());
		email.sendKeys(getTime() + "dmitry@gmail.com");

		password.sendKeys("ThisIsMyCoolPassword!123");
		passwordConfirmation.sendKeys("ThisIsMyCoolPassword!123");

		// Just for me, you dont need to use this
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement marriedRadioButton = driver.findElement(By.xpath("//input[@value='married']"));
		WebElement readingCheckbox = driver.findElement(By.xpath("//input[@value='reading']"));
		WebElement cricketCheckbox = driver.findElement(By.xpath("//input[@value='cricket ']"));

		marriedRadioButton.click();
		readingCheckbox.click();
		cricketCheckbox.click();

		submitButton.click();

		// Verification
		WebElement successMessage = driver.findElement(By.className("piereg_message"));
		Assert.assertTrue(successMessage.getText().equals("Thank you for your registration"),
				"Success message is not correct.");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/** This method returns current time in MMddyyyyHHmmss format */
	private String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyyHHmmss");
		Date date = new Date();
		return formatter.format(date);
	}
}
