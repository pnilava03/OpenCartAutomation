package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.PropertiesUtil;

public class SearchForProductPageTest extends BaseTest {
	
	PropertiesUtil prop= new PropertiesUtil();
	
	
	
	@BeforeClass(alwaysRun = true)
	public void searchForProductPageSetUp() throws InterruptedException {
		accountsPage=loginPage.doLogin(prop.getPropertiesValue("userName"), prop.getPropertiesValue("Password"));
		searchForProductPage=accountsPage.doHoverMouseOnMyAccountDropdown();
		
	}
	
	@Test (priority = 1)
	public void searchForProductTest() throws InterruptedException {
		boolean searchBoxPresent= searchForProductPage.enterProductNameInSearchBox("macbook pro");
		Assert.assertTrue(searchBoxPresent);
		}
	
	@Test (priority = 2)
	public void verifyHeaderTextTest() {
		String headerText= searchForProductPage.getSearchPageHeader();
		Assert.assertEquals(headerText, "Search - macbook pro");
	}
	
	
	@Test (priority = 3)
	public void productCountTest() {
		int productCount= searchForProductPage.getProductCount();
		System.out.println("Total number of products displayed: "+ productCount);
		Assert.assertEquals(productCount,2);
	}
	

}
