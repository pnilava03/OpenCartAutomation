package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;
import static com.qa.opencart.constants.AppConstant.*;
import com.qa.opencart.utils.PropertiesUtil;

public class LoginPageTest extends BaseTest {

	PropertiesUtil prop = new PropertiesUtil();

	@Test(priority = 0)
	public void verifyPageTitle() {
		String actualTitle = loginPage.getLoginPageTitle();
		ChainTestListener.log("Login Page Title is : " + actualTitle);
		Assert.assertEquals(actualTitle, LOGIN_PAGE_TITLE);
	}

	@Test(priority = 1)
	public void verifyCurrentURL() {
		String actualURL = loginPage.getCurrentURL();
		ChainTestListener.log("Login Page URL is : " + actualURL);
		Assert.assertEquals(actualURL, prop.getPropertiesValue("url"));
	}

	@Test(priority = 2)
	public void verifyReturingCustomerText() {
		String actualText = loginPage.getReturningCustomerText();
		ChainTestListener.log("Returning Customer Text is : " + actualText);
		Assert.assertEquals(actualText, RETURNING_CUSTOMER_TEXT);
	}

	@Test(priority = 3)
	public void verifyForgottenLink() {
		ChainTestListener.log("Forgotten Link is Displayed : " + loginPage.isForgottenLinkDisplay());
		Assert.assertTrue(loginPage.isForgottenLinkDisplay());
	}

	@Test(priority = 4)
	public void loginToTheApplication() throws InterruptedException {
		ChainTestListener.log("Login with username : " + prop.getPropertiesValue("userName") + " and password : "
				+ prop.getPropertiesValue("Password"));
		loginPage.doLogin(prop.getPropertiesValue("userName"), prop.getPropertiesValue("Password"));
		Thread.sleep(3000);

	}

}
