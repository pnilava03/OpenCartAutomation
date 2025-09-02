package com.qa.opencart.pages;

import java.lang.annotation.ElementType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;

public class LogoutPage {
	WebDriver driver;
	ElementUtil elementUtil;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private final By logout = By
			.xpath("//ul[@class='mz-sub-menu-96 dropdown-menu show']/li/a/div/span[contains(text(),'Logout')]");

	private final By AccountLogoutText = By.xpath("//div[@id='content']/h1");
	
	
	/**
	 * this method click on logout button from My Account drop down
	 */
	public void clickOnLogout() {
		System.out.println("Clicking on logout link from My Account drop down");
		elementUtil.doClick(logout);
		
	}
	
	/**
	 * this method verify the logout text
	 * @return logout text
	 */
	
	public String verifyLogoutText() {
		String logoutText= elementUtil.waitForElementVisible(AccountLogoutText, AppConstant.DEFAULT_TIME_OUT).getText();
		System.out.println("Verifying Account Logout Text:: "+logoutText);
		System.out.println("Successfully logout from the application");
		return logoutText;
		
	}

}

