package com.herokuapp.theinternet.forgotpassword.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.pages.EmailSentPage;
import com.herokuapp.theinternet.pages.ForgotPasswordPage;
import com.herokuapp.theinternet.pages.HomePage;

public class ForgotPasswordTests extends BaseTest {

	@Test(priority = 1)
	public void logInTest() {
		// Open Home Page
		HomePage homePage = new HomePage(driver);
		homePage.open();

		// Click Forgot Password Link
		ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
		forgotPasswordPage.waitForForgotPasswordPageToLoad();

		// retrieve Password
		EmailSentPage emailSentPage = forgotPasswordPage.executeRetrievePassword("user@domain.com");

		// wait for success message
		emailSentPage.waitForEmailSentPageToLoad();
		String message = emailSentPage.getMessageText();

		Assert.assertTrue(message.contains("Your e-mail's been sent!"), "Message doesn't contain expected text.");
	}
}
