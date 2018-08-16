package com.packt.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class WindowsAndFramesTest extends BaseTest {

	@Test
	public void newWindowTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/windows");
		System.out.println("Page opened!");

		// Print page title and url before link click
		System.out.println("Page title before click: " + driver.getTitle());
		System.out.println("Page url before click: " + driver.getCurrentUrl());

		// SLEEP FOR STUDENTS TO SEE THE SCREEN
		sleep();

		// Clicking Click Here Link
		WebElement link = driver.findElement(By.linkText("Click Here"));
		link.click();

		// SLEEP FOR STUDENTS TO SEE THE SCREEN
		sleep();

		// Print page title and url after link click
		System.out.println("Page title after click: " + driver.getTitle());
		System.out.println("Page url after click: " + driver.getCurrentUrl());

		// Switching to new window
		String firstWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowsIterator = allWindows.iterator();

		while (windowsIterator.hasNext()) {
			String windowHandle = windowsIterator.next().toString();
			if (!windowHandle.equals(firstWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Print page title and url after switch to new window
		System.out.println("Page title after switch: " + driver.getTitle());
		System.out.println("Page url after switch: " + driver.getCurrentUrl());

		Assert.assertTrue(driver.getTitle().equals("New Window"), "Title of new window is incorrect");
		Assert.assertTrue(driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/windows/new"),
				"URL of new window is incorrect");
	}

	@Test
	public void wysiwygEditorTest() {
		// Opening page
		driver.get("http://the-internet.herokuapp.com/iframe");
		System.out.println("Page opened!");

		// SLEEP FOR STUDENTS TO SEE THE SCREEN
		sleep();
		
		WebElement iFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iFrame);

		// Typing text
		WebElement textArea = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
		textArea.clear();
		textArea.sendKeys("Hello, world!");

		// SLEEP FOR STUDENTS TO SEE THE SCREEN
		sleep();

		Assert.assertTrue(textArea.getText().equals("Hello, world!"),
				"Text in editor is not correct. Its " + textArea.getText());
	}
}
