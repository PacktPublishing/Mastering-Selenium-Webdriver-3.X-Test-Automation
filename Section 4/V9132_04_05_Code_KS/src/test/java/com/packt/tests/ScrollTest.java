package com.packt.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class ScrollTest extends BaseTest {

	@Test
	public void scrollTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/infinite_scroll");
		System.out.println("Page opened!");

		List<WebElement> paragraphElements = driver.findElements(By.xpath("//div[@class='jscroll-added']"));
		int numberOfParagraphs = paragraphElements.size();

		while (numberOfParagraphs < 10) {
			System.out.println("Current number of paragraph: " + numberOfParagraphs);
			// SLEEP FOR STUDENTS TO SEE SCREEN
			sleep();

			// Perform scroll to the bottom
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			// Get new number of Paragraphs
			paragraphElements = driver.findElements(By.xpath("//div[@class='jscroll-added']"));
			numberOfParagraphs = paragraphElements.size();
		}

		Assert.assertTrue(numberOfParagraphs == 10,
				"There should be 10 paragraphs, but there are " + numberOfParagraphs);
	}
}
