package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private final By userName = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@type='submit']");
	private final By forgetlink = By.linkText("Forgotten Password");
	private final By verifyingReturingCustomerText = By.xpath("(//div[@class='card-body p-4'])[2]/h2");
	

	/**
	 * Get the title of the login page
	 * 
	 * @return title of the page
	 */
	public String getLoginPageTitle() {
		String title = elementUtil.waitFotTitleIs(AppConstant.LOGIN_PAGE_TITLE, AppConstant.DEFAULT_TIME_OUT);
		System.out.println("Login Page title :: " + title);
		return title;
	}

	/**
	 * Get the current URL of the login page
	 * 
	 * @return current URL of the page
	 */
	public String getCurrentURL() {
		String url = elementUtil.waitForURLToBe(AppConstant.DEFAULT_TIME_OUT);
		System.out.println("Current URL (clickable): " +  url);

		return url;
	}

	/**
	 * Check if the "Forgotten Password" link is displayed on the login page
	 * 
	 * @return true if the link is displayed, false otherwise
	 */

	public boolean isForgottenLinkDisplay() {
		return elementUtil.isElementDisplayed(forgetlink);
	}
	
	
	
	/**
	 * Get the text of the "Returning Customer" section on the login page
	 * 
	 * @return text of the "Returning Customer" section
	 */

	public String getReturningCustomerText() {
		String returningCustomerText = elementUtil.doElementGetText(verifyingReturingCustomerText);
		System.out.println("Verifying Returning Customer Text:: " + returningCustomerText);
		return returningCustomerText;
	}

	/**
	 * Perform login action with the provided email and password
	 * 
	 * @param email user's email
	 * @param pawd  user's password
	 * @return text of the "My Account" section after successful login
	 */

	public AccountPage doLogin(String email, String pawd) {
		System.out.println("Trying to login to the application");
		System.out.println("Enter username ::" + email);
		elementUtil.waitForElementVisible(userName, AppConstant.DEFAULT_TIME_OUT).sendKeys(email);
		System.out.println("Enter password ::" + pawd);
		elementUtil.doSendKeys(password, pawd);
		System.out.println("click on login button...");
		elementUtil.doClick(loginBtn);
		System.out.println("Successfully Login to the Application");
		// After login, return the AccountPage object
		return new AccountPage(driver);

	}

	

}
