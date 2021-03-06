package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class DynamicallyLoadedElementsTest extends BaseTest {

	@Test
	public void startButtonTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		System.out.println("Page opened!");

		// Clicking start button
		WebElement startButton = driver.findElement(By.xpath("//button"));
		startButton.click();

		// Verifying Hello World text
		WebElement finishText = driver.findElement(By.id("finish"));
		String text = finishText.getText();
		Assert.assertTrue(text.equals("Hello World!"), "'Hello World! text is not present on the page.'");
	}
}
