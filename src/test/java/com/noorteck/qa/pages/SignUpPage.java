package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utils.CommonUI;

public class SignUpPage extends CommonUI {
	public SignUpPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user_email")
	WebElement emailField;

	@FindBy(id = "user_password")
	WebElement passwordField;

	@FindBy(name = "commit")
	WebElement signUpButton;

	@FindBy(xpath = "//*[@data-test='sign-in']")
	WebElement signInButton;


	
	public void enterEmail(String email) {
		enter(emailField, email);
	}
	
	public void enterPassword(String password) {
		enter(passwordField, password);
		
	}
	
	public void clickSignUp() {
		click(signUpButton);
	}
	
	public void clickSignIn() {
		clickSignIn();
	}

}
