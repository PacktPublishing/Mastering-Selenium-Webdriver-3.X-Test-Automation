package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class ForgotPasswordPage extends BasePageObject {

	private By emailFieldLocator = By.id("email");
	private By retrievePasswordButtonLocator = By.tagName("button");


	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}


	/** Wait for Retrieve Password button to be visible on the page */
	public void waitForForgotPasswordPageToLoad() {
		waitForVisibilityOf(retrievePasswordButtonLocator, 5);
	}


	/** Execute RetrievePassword */
	public EmailSentPage executeRetrievePassword(String email) {
		find(emailFieldLocator).sendKeys(email);
		find(retrievePasswordButtonLocator).click();
		return new EmailSentPage(driver);
	}
}
