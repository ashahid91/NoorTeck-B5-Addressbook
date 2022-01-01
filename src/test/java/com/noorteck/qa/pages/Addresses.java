package com.noorteck.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.noorteck.qa.utils.CommonUI;

public class Addresses extends CommonUI {
	
	@FindBy (css="a[data-test='create'")
	WebElement newAddresses;
	
	@FindBy(id="address_first_name")
	WebElement firstNameField;
	
	@FindBy(id="address_last_name")
	WebElement lastNameField;
	
	@FindBy (id="address_street_address")
	WebElement addressField1;
	
	@FindBy(id="address_secondary_address")
	WebElement addressField2;
	
	@FindBy(id="address_city")
	WebElement cityField;
	
	@FindBy(id="address_state")
	WebElement stateDropdown;
	
	@FindBy(id="address_zip_code")
	WebElement zipCodeField;
	
	@FindBy(id="address_country_us")
	WebElement countryUSRadiobutton;
	
	@FindBy(id="address_age")
	WebElement ageField;
	
	@FindBy(id="address_website")
	WebElement websisteField;
	
	@FindBy(id="address_phone")
	WebElement phoneField;
	
	@FindBy(id="address_interest_dance")
	WebElement dancingCheckBox;
	
	@FindBy(id="address_note")
	WebElement noteTextField;
	
	
	@FindBy (xpath="//*[@value='Create Address']")
	WebElement createAddressButton;
	
	@FindBy(xpath="//*[text()= 'Address was successfully created.']")
	WebElement message;
	
	@FindBy(xpath="//*[@data-test='edit']")
	WebElement editButton;
	
	@FindBy(xpath="//*[@data-test='list']")
	WebElement listButton;
	
	public Addresses() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewAddress() {
		click(newAddresses);
	}
	
	public void enterFirstName(String firstName) {
		enter(firstNameField, firstName);
	}
	
	public void enterLastName(String lastName) {
		enter(lastNameField, lastName);
	}
	
	public void enterAddress1(String address1) {
		enter(addressField1,address1);
	}
	
	public void enterAddress2(String address2) {
		enter(addressField2, address2);
	}
	
	public void enterCity(String city) {
		enter(cityField,city);
	}
	
	public void chooseStateDropDown(String methodName, String indexTextValue ) {
		selectFromDropdown(stateDropdown, methodName, indexTextValue);
	}
	
	public void enterZipCode(String zipCode) {
		enter(zipCodeField, zipCode);
	}
	
	public void clickUSRadio() {
		click(countryUSRadiobutton);
	}
	
	public void enterAge(String age) {
		enter(ageField, age);
	}
	
	public void enterWebsite(String website) {
		enter(websisteField, website);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		enter(phoneField, phoneNumber);
	}
	
	
	public void clickDancingCheckBox() {
		click(dancingCheckBox);
	}
	
	public void enterNote(String note) {
		enter(noteTextField, note);
	}
	
	
	public void clickCreateAddresses() {
		click(createAddressButton);
	}
	
	public String getTextMessage() {
		return getText(message);
	}
	
	public void clickEditButton() {
		click(editButton);
	}
	
	public void clickListButton() {
		click(listButton);
	}
	
	
	
	
	
	
}
