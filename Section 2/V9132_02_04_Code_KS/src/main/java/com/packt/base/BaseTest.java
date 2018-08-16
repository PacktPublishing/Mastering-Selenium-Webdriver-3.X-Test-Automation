package com.packt.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;


	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	protected void setUp(@Optional("chrome") String browser) {
		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		driver = factory.createDriver();
		
		// You don't need to have this speep.
		// I added it only for you to see the browser
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// maximize browser window
		driver.manage().window().maximize();
	}


	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		// Closing driver
		System.out.println("[Closing driver]");
		driver.quit();
	}
}
