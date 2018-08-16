package com.herokuapp.theinternet.login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.LoginPage;

public class NegativeLoginTests extends BaseTest {

	@Test(priority = 1)
	public void incorrectUsernameTest() {
		// Open Login page directly
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();

		// Execute negative login
		loginPage.negativeLogIn("incorrectUsername", "SuperSecretPassword!");

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		Assert.assertTrue(message.contains("Your username is invalid!"), "Message doesn't contain expected text.");
	}

	@Test(priority = 2)
	public void incorrectPasswordTest() {
		// Open Login page directly
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();

		// Execute negative login
		loginPage.negativeLogIn("tomsmith", "incorrectPassword");

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		Assert.assertTrue(message.contains("Your password is invalid!"), "Message doesn't contain expected text.");
	}

}
