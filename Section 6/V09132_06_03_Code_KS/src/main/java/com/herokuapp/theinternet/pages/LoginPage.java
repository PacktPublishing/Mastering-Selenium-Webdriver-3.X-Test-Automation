package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.BasePageObject;

public class LoginPage extends BasePageObject {

	private String loginPageUrl = "http://the-internet.herokuapp.com/login";

	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By logInButtonLocator = By.tagName("button");
	private By errorMessageLocator = By.id("flash");


	public LoginPage(WebDriver driver) {
		super(driver);
	}


	/** Open page using it's url */
	public void open() {
		openUrl(loginPageUrl);
	}


	/** Wait for username field to be visible on the page */
	public void waitForLoginPageToLoad() {
		waitForVisibilityOf(usernameLocator, 5);
	}


	/** Execute positive log in */
	public SecureAreaPage logIn(String username, String password) {
		enterUsernameAndPassword(username, password);
		clickLogInButton();
		return new SecureAreaPage(driver);
	}


	/** Execute negative log in */
	public void negativeLogIn(String username, String password) {
		enterUsernameAndPassword(username, password);
		clickLogInButton();
		waitForErrorMessage();
	}


	/** Type given username and password */
	private void enterUsernameAndPassword(String username, String password) {
		System.out.println("Entering username and password");
		find(usernameLocator).sendKeys(username);
		find(passwordLocator).sendKeys(password);
	}


	/** Click on Login button */
	private void clickLogInButton() {
		System.out.println("Clicking Login button");
		find(logInButtonLocator).click();
	}


	/** Wait for error message to be visible on the page */
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMessageLocator, 5);
	}


	public String getErrorMessageText() {
		return find(errorMessageLocator).getText();
	}
}
