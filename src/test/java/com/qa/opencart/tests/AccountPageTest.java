package com.qa.opencart.tests;



import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.PropertiesUtil;

public class AccountPageTest extends BaseTest {
	
	PropertiesUtil prop= new PropertiesUtil();
	
	@BeforeClass (alwaysRun = true)
	public void accountPageSetUp() {
		accountsPage= loginPage.doLogin(prop.getPropertiesValue("userName"), prop.getPropertiesValue("Password"));
	}
	
	
	@Test (priority = 1)
	public void accountPageTitleTest() {
		String actualTitle= accountsPage.getAccountPageTitle();
		ChainTestListener.log("Account Page Title is : "+ actualTitle);
		System.out.println("Account Page Title is: "+ actualTitle);
	}
	
	@Test (priority = 2)
	public void hoverMouseOnMyAccountDropdownTest() throws InterruptedException {
		accountsPage.doHoverMouseOnMyAccountDropdown();
		Thread.sleep(3000);
		
	}
	
	@Test (priority = 3)
	public void myOrderAndMyAffiliateAccountTextTest() {
		List<String> actualList= accountsPage.getMyOrdersAndMyAffiliateAccountText();
		ChainTestListener.log("List of header Text is : "+ actualList);
		Assert.assertEquals(actualList, AppConstant.EXPECTED_ACCOUNTS_SECTION_LIST);

}
	
}
