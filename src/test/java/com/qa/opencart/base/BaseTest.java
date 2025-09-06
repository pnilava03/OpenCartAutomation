package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.SearchForProductPage;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.PropertiesUtil;

public class BaseTest {

	WebDriver driver;
	PropertiesUtil prop;
	protected LoginPage loginPage;
	protected AccountPage accountsPage;
	protected LogoutPage logoutPage;
	protected SearchForProductPage searchForProductPage;
	
	
	
	@BeforeTest(alwaysRun = true)
	public void setUp() {
		prop = new PropertiesUtil();
		driver = DriverFactory.getInstance(prop.getPropertiesValue("Browser")).getDriver();
		driver.get(prop.getPropertiesValue("url"));
		loginPage= new LoginPage(driver);
		

	}
	
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitBrowser();
		
	}

}
