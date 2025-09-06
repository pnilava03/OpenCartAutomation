package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import static com.qa.opencart.constants.AppConstant.*;
import com.qa.opencart.utils.PropertiesUtil;

public class LoginPageTest extends BaseTest {

	PropertiesUtil prop = new PropertiesUtil();

	@Test(priority = 0)
	public void verifyPageTitle() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, LOGIN_PAGE_TITLE);
	}

	@Test(priority = 1)
	public void verifyCurrentURL() {
		String actualURL = loginPage.getCurrentURL();
		Assert.assertEquals(actualURL, prop.getPropertiesValue("url"));
	}

	@Test(priority = 2)
	public void verifyReturingCustomerText() {
		String actualText = loginPage.getReturningCustomerText();
		Assert.assertEquals(actualText, RETURNING_CUSTOMER_TEXT);
	}

	@Test(priority = 3)
	public void verifyForgottenLink() {
		Assert.assertTrue(loginPage.isForgottenLinkDisplay());
	}

	@Test(priority = 4)
	public void loginToTheApplication() throws InterruptedException {
		loginPage.doLogin(prop.getPropertiesValue("userName"), prop.getPropertiesValue("Password"));
		Thread.sleep(3000);

	}

}
