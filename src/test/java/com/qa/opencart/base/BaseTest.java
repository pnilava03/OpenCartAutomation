package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.SearchForProductPage;
import com.qa.opencart.utils.PropertiesUtil;
import com.qa.opencart.utils.ReportUtils;

public class BaseTest {

	WebDriver driver;
	PropertiesUtil prop;
	protected LoginPage loginPage;
	protected AccountPage accountsPage;
	protected LogoutPage logoutPage;
	protected SearchForProductPage searchForProductPage;
	
	@SuppressWarnings("static-access")
	@BeforeTest(alwaysRun = true)
	public void setUp() {
		prop = new PropertiesUtil();
		driver = DriverFactory.getInstance(prop.getPropertiesValue("Browser")).getDriver();
		driver.get(prop.getPropertiesValue("url"));
		loginPage= new LoginPage(driver);
		}
	
	
	@AfterMethod(alwaysRun = true)
	public void takeScreenShot(ITestResult result) {
		if(result.isSuccess()) {
			ChainTestListener.embed(ReportUtils.takeScreenshotAsBase64(), "image/png");	
		}else {
			ChainTestListener.embed(ReportUtils.takeScreenshotAsBase64(), "image/png");
		}	
		
	}
		
	
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitBrowser();
		
	}

}
