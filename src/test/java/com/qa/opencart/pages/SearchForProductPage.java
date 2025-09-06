package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class SearchForProductPage {

	WebDriver driver;
	ElementUtil elementUtil;

	public SearchForProductPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private final By searchBox = By.name("search");
	private final By searchIcon = By.xpath("(//div[@id='search']/descendant::button)[2]");
	private final By header = By.cssSelector("#entry_212456 h1");
	private final By productCount = By.cssSelector(".product-layout .product-thumb");

	/**
	 * Enter product name in the search box and click on the search icon
	 * 
	 * @param productName The name of the product to search for
	 */

	public boolean enterProductNameInSearchBox(String productName) {
		boolean searchElementPresent = elementUtil.isElementDisplayed(searchBox);
		elementUtil.doSendKeys(searchBox, productName);
		elementUtil.doClick(searchIcon);
		return searchElementPresent;

	}

	/**
	 * Get the header text of the search results page
	 * 
	 * @return The header text of the search results page
	 */
	public String getSearchPageHeader() {
		elementUtil.waitForElementVisible(header, 10);
		String headerText = elementUtil.doElementGetText(header);
		System.out.println("Search Page Header:: " + headerText);
		return headerText;
	}

	/**
	 * Get the count of products displayed on the search results page
	 * 
	 * @return The count of products displayed on the search results page
	 */
	public int getProductCount() {
		int productCountValue = elementUtil.getElements(productCount).size();
		System.out.println("Total Product Count:: " + productCountValue);
		return productCountValue;
	}

}
