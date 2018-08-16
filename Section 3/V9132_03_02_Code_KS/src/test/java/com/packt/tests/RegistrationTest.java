package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class RegistrationTest extends BaseTest {

	@Test
	public void registrationTest() {
		driver.get("http://demoqa.com/registration/");

		WebElement registrationForm = driver.findElement(By.className("entry-content"));
		WebElement firstName = driver.findElement(By.cssSelector("#name_3_firstname"));
		WebElement lastName = driver.findElement(By.id("name_3_lastname"));
		WebElement phoneNumber = driver.findElement(By.name("phone_9"));

		WebElement username = driver.findElement(By.id("username"));
		WebElement email = driver.findElement(By.name("e_mail"));
		WebElement about = driver.findElement(By.tagName("textarea"));
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password_2']"));
		WebElement passwordConfirmation = driver.findElement(By.xpath("//input[contains(@class,'equals[password_2]')]"));
		WebElement submitButton = driver.findElement(By.xpath("//*[@value='Submit']"));
		
		WebElement link1 = driver.findElement(By.linkText("Powered by Oneiric Tech Solutions Pvt. Ltd."));
		WebElement link2 = driver.findElement(By.partialLinkText("Powered by Oneiric"));

	}
}
