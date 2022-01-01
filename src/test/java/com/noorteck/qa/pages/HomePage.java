package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utils.CommonUI;

public class HomePage extends CommonUI {

	@FindBy(css = "a[data-test='home']")
	WebElement homeButton;

	@FindBy(css = "a[data-test='addresses']")
	WebElement addressesButton;

	@FindBy(css = "a[data-test='sign-out']")
	WebElement signOutButton;

	@FindBy(xpath = "//h1[text()='Welcome to Address Book']")
	WebElement addressBookTitle;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}
	
	public void clickHome() {
		click(homeButton);
	}
	
	public void clickSignOut() {
		click(signOutButton);
	}
	
	public void clickAddresses() {
		click(addressesButton);
	}
	
	public String welcomeTitke() {
	return	getText(addressBookTitle);
	}

}
