package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;
import static com.qa.opencart.constants.AppConstant.*;

public class AccountPage {
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	
	
	private final By MyAccount = By.xpath("(//div[@id='content']/div/h2)[1]");
	private final By MyaccountDropDown = By
			.xpath("//div[@id='widget-navbar-217834']/ul/li/a/div/span[contains(text(),' My account')]");
	
	private final By myOrderAndMyaffiliateAccount = By.xpath("//div[@class='card mb-3']/h2");
	
	
	public String getAccountPageTitle() {
		String title= elementUtil.waitFotTitleIs(ACCOUNTS_PAGE_TITLE, DEFAULT_TIME_OUT);
		System.out.println("Account Page Title:: "+title);
		return title;
		
	}
	
	/**
	 * Hover mouse on My Account dropdown
	 * 
	 * @return WebElement of the My Account dropdown
	 * @throws InterruptedException
	 * 
	 */
	public SearchForProductPage doHoverMouseOnMyAccountDropdown() throws InterruptedException {
		WebElement wb = elementUtil.getElement(MyaccountDropDown);
		elementUtil.do_mouseHover(wb);
		return new SearchForProductPage(driver);

	}
	
	
	public LogoutPage hoverMouseOnMyAccountDropdown() throws InterruptedException {
		WebElement wb = elementUtil.getElement(MyaccountDropDown);
		elementUtil.do_mouseHover(wb);
		return new LogoutPage(driver);

	}
	
	

	

	/**
	 * Get the text of the "My Orders and My Affiliate Account" section on the login
	 * page
	 * 
	 * @return text of the "My Orders and My Affiliate Account" section
	 */

	public List<String> getMyOrdersAndMyAffiliateAccountText() {
		List<WebElement> myOrdersAndMyAffiliateAccountList = elementUtil.getElements(myOrderAndMyaffiliateAccount);
		for (int i = 0; i < myOrdersAndMyAffiliateAccountList.size(); i++) {
			System.out.println(myOrdersAndMyAffiliateAccountList.get(i).getText());
		}

		return myOrdersAndMyAffiliateAccountList.stream().map(ele -> ele.getText()).toList();

	}

}
