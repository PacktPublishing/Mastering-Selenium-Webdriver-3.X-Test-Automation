package com.herokuapp.theinternet.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;

	public BrowserDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}

	public WebDriver createDriver() {
		System.out.println("[Setting up driver: " + browser + "]");

		// Creating driver
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
			driver.set(new InternetExplorerDriver());
			break;

		default:
			System.out.println("[Couldn't set: " + browser + ". Its unknown. Starting chrome instead]");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}

	/** Starting tests using Selenium grid */
	public WebDriver createDriverGrid() {
		// Setting up selenium grid hub url
		URL url = null;
		try {
			url = new URL("http://192.168.0.2:4444/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		System.out.println("Starting " + browser + " on grid");

		// Using DesiredCapabilities to set up browser
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);

		// Creating driver
		try {
			driver.set(new RemoteWebDriver(url, capabilities));
		} catch (WebDriverException e) {
			if (e.getMessage().contains("Error forwarding")) {
				System.out.println("[Couldn't set: " + browser + ". Its unknown. Starting chrome instead]");
				capabilities.setBrowserName("chrome");
				driver.set(new RemoteWebDriver(url, capabilities));
			}
		}

		return driver.get();
	}

	/** Starting tests using sauce labs grid */
	public WebDriver createDriverSauce(String platform, String testName) {
		System.out.println("[Setting up driver: " + browser + " on SauceLabs]");
		String username = "masteringselenium";
		String accessKey = "f52cc90b-6273-4935-a916-c7eb9b0d31f4";
		String url = "http://" + username + ":" + accessKey + "@ondemand.saucelabs.com:80/wd/hub";

		// Setting up DesiredCapabilities (browser and os)
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);

		if (platform == null) {
			// If platform is not provided, start tests on Windows 10
			caps.setCapability("platform", "Windows 10");
		} else {
			caps.setCapability("platform", platform);
		}

		// Setting up test name
		caps.setCapability("name", testName);

		try {
			driver.set(new RemoteWebDriver(new URL(url), caps));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver.get();
	}

}
