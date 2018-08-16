package com.packt.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement marriedRadioButton = driver.findElement(By.xpath("//input[@value='married']"));
		WebElement readingCheckbox = driver.findElement(By.xpath("//input[@value='reading']"));
		WebElement cricketCheckbox = driver.findElement(By.xpath("//input[@value='cricket ']"));

		marriedRadioButton.click();
		readingCheckbox.click();
		cricketCheckbox.click();

		WebElement countryDropdown = driver.findElement(By.id("dropdown_7"));
		Select country = new Select(countryDropdown);
		country.selectByIndex(7);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		country.selectByValue("Australia");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		country.selectByVisibleText("Canada");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement monthsDropdown = driver.findElement(By.id("mm_date_8"));
		WebElement monthsOption = driver.findElement(By.xpath("//*[@value='6']"));

		WebElement dateDropdown = driver.findElement(By.id("dd_date_8"));
		WebElement dateOption = driver.findElement(By.xpath("//*[@value='30']"));

		WebElement yearDropdown = driver.findElement(By.id("yy_date_8"));
		WebElement yearOption = driver.findElement(By.xpath("//*[@value='1988']"));

		monthsDropdown.click();
		monthsOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		dateDropdown.click();
		dateOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		yearDropdown.click();
		yearOption.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
