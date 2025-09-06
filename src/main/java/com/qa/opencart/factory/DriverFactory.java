package com.qa.opencart.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	/**
	 * @author NILAVA PAL
	 */
	private static final Logger logger = Logger.getLogger(DriverFactory.class.getName());
	private static volatile DriverFactory instance;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	private DriverFactory() {

	}

	/**
	 * This method is used for initialized the Browser
	 * 
	 * @param browser
	 */

	private void init_Driver(String browser) {
		logger.info("============================ Initializing Browser ============================ " + browser);

		switch (browser.toLowerCase().trim()) {

		case "chrome":
			if (tlDriver != null) {
				tlDriver.set(new ChromeDriver());
			} else {
				throw new NullPointerException("Local thread driver is null :: " + tlDriver);
			}

			break;

		case "ff":
			if (tlDriver != null) {
				tlDriver.set(new FirefoxDriver());
			} else {
				throw new NullPointerException("Local thread driver is null :: " + tlDriver);
			}
			break;

		case "edge":
			if (tlDriver != null) {
				tlDriver.set(new EdgeDriver());
			} else {
				throw new NullPointerException("Local thread driver is null :: " + tlDriver);
			}
			break;

		case "ie":
			if (tlDriver != null) {
				tlDriver.set(new InternetExplorerDriver());
			} else {
				throw new NullPointerException("Local thread driver is null :: " + tlDriver);
			}
			break;

		case "safari":
			if (tlDriver != null) {
				tlDriver.set(new SafariDriver());
			} else {
				throw new NullPointerException("Local thread driver is null :: " + tlDriver);
			}
			break;
			
		case "headless":
			if (tlDriver != null) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				tlDriver.set(new ChromeDriver(options));
			} else {
				throw new NullPointerException("Local thread driver is null :: " + tlDriver);
			}
			break;

		default:
			throw new IllegalArgumentException("Unexpected browser name: " + browser);
		}

		
		tlDriver.get().manage().window().maximize();
		tlDriver.get().manage().deleteAllCookies();

	}

	/**
	 * This is single tone class for getInstance
	 * 
	 * @param browserName
	 * @return instance
	 */
	public static DriverFactory getInstance(String browserName) {
		if (instance == null) {

			synchronized (DriverFactory.class) {
				if (instance == null) {
					instance = new DriverFactory();
				}

			}
		}

		if (tlDriver.get() == null) {
			instance.init_Driver(browserName);
		}

		return instance;
	}

	/**
	 * this method to get the driver.
	 * 
	 * @return driver
	 */

	public WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 *This method is used for quit the browser and close the thread session
	 */

	public static void quitBrowser() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}

	}

}
