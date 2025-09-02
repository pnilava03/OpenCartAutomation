package com.qa.opencart.tests;



import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.PropertiesUtil;

public class AccountPageTest extends BaseTest {
	
	PropertiesUtil prop= new PropertiesUtil();
	
	@BeforeClass
	public void accountPageSetUp() {
		accountsPage= loginPage.doLogin(prop.getPropertiesValue("userName"), prop.getPropertiesValue("Password"));
	}
	
	
	@Test (priority = 1)
	public void accountPageTitleTest() {
		String actualTitle= accountsPage.getAccountPageTitle();
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
		List<String> expectedList= Arrays.asList("My Account","My Orders","My Affiliate Account");
		for(String s: actualList) {
			System.out.println(s);
			Assert.assertTrue(actualList.equals(expectedList));
		}
}
	
}
