package com.herokuapp.theinternet.login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.HomePage;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;

public class PositiveLoginTests extends BaseTest {

	@Test(priority = 1)
	public void logInTest() {
		// Open Home Page
		HomePage homePage = new HomePage(driver);
		homePage.open();

		// Click Form Authentication Link
		LoginPage loginPage = homePage.clickFormAuthenticationLink();

		// Wait for login page to load
		loginPage.waitForLoginPageToLoad();

		// Execute positive login
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

		// wait for success message
		secureAreaPage.waitForSecureAreaPageToLoad();
		String message = secureAreaPage.getMessageText();

		Assert.assertTrue(message.contains("You logged into a secure area!"), "Message doesn't contain expected text.");
	}

}
