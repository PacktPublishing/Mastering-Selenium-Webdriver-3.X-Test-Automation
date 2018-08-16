package com.herokuapp.theinternet;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "environment", "platform" })
	protected void setUp(@Optional("chrome") String browser, @Optional("local") String environment,
			@Optional String platform, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);

		// Starting tests locally or on the grid depending on the environment parameter
		if (environment.equals("grid")) {
			driver = factory.createDriverGrid();
		} else if (environment.equals("sauce")) {
			driver = factory.createDriverSauce(platform, testName);
		} else {
			driver = factory.createDriver();
		}

		// STATIC SLEEP FOR STUDENTS TO SEE TEST EXECUTION
		sleep();

		// maximize browser window
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		// Closing driver
		System.out.println("[Closing driver]");
		driver.quit();
	}

	// STATIC SLEEP FOR STUDENTS TO SEE TEST EXECUTION
	protected void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//test-output//screenshots//" + fileName + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
