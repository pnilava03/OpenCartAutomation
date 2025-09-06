package com.qa.opencart.tests;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import static com.qa.opencart.constants.AppConstant.*;
import com.qa.opencart.utils.PropertiesUtil;

public class LogoutPageTest extends BaseTest {
	PropertiesUtil prop= new PropertiesUtil();
	
	
	@BeforeClass(alwaysRun = true)
	public void logoutPageSetUp() throws InterruptedException {
	accountsPage=loginPage.doLogin(prop.getPropertiesValue("userName"), prop.getPropertiesValue("Password"));
	logoutPage=accountsPage.hoverMouseOnMyAccountDropdown();
		
		
	}
	
	@Test (priority = 1)
	public void clickOnLogoutButton() throws InterruptedException {
		Thread.sleep(3000);
		logoutPage.clickOnLogout();
		Thread.sleep(3000);
		String verifyActualText= logoutPage.verifyLogoutText();
		Assert.assertEquals(verifyActualText, LOGOUT_PAGE_TEXT);
		
		
	}
	
	

}
