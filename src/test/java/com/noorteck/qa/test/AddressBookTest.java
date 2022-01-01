package com.noorteck.qa.test;

import com.noorteck.qa.pages.Addresses;
import com.noorteck.qa.pages.HomePage;
import com.noorteck.qa.pages.SignInPage;
import com.noorteck.qa.pages.SignUpPage;
import com.noorteck.qa.utils.CommonUI;
import com.noorteck.qa.utils.ObjInitialize;

public class AddressBookTest extends ObjInitialize {
	
	public static void main(String[] args) {
		String url= "http://a.testaddressbook.com/sign_up";
		
		CommonUI com= new CommonUI();
		com.openBrowser("chrome");
		AddressBookTest testObj = new AddressBookTest();
		
		testObj.initializeClassObj();
		com.navigate(url);
		testObj.testCaseOne();
		com.quitBrowser();
		url= "http://a.testaddressbook.com/sign_in";
		com.openBrowser("chrome");
		com.navigate(url);
		testObj.testCaseTwo();
		
		com.quitBrowser();
		
	}
	
	public void testCaseOne() {
		SignUpPage signUpPageObj = new SignUpPage();
		signUpPageObj.enterEmail("chicken.biryani@gmail.com");
		signUpPageObj.enterPassword("aloobukhara");
		signUpPageObj.clickSignUp();
		HomePage homePageObj = new HomePage();
		String welcomeMessage =homePageObj.welcomeTitke();
		
		if(welcomeMessage.contains("Welcome to Address Book")) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Test case failed");
		}
	}
	
	public void testCaseTwo() {
		
		SignInPage signInObj= new SignInPage();
		
		signInObj.enterEmail("chicken.biryani@gmail.com");
		signInObj.enterPassword("aloobukhara");
		signInObj.clickSignIn();
		
		HomePage homePageObj = new HomePage();
		
		homePageObj.clickAddresses();
		
		Addresses addressesObj = new Addresses();
		
		addressesObj.clickNewAddress();
		
		addressesObj.enterFirstName("Elon");
		addressesObj.enterLastName("Musk");
		addressesObj.enterAddress1("123 main street");
		addressesObj.enterCity("Reston");
		addressesObj.chooseStateDropDown("value", "VA");
		addressesObj.clickUSRadio();
		addressesObj.enterAge("22");
		addressesObj.enterPhoneNumber("123-233-3434");
		addressesObj.clickDancingCheckBox();
		addressesObj.enterNote("AUtomation is Fun");
		addressesObj.clickCreateAddresses();
		addressesObj.clickListButton();
		
		
		
		
		
		
		
		
	}
	

}

/**
 * -------------------------------------- INSTRUCTIONS
 * --------------------------------------------
 * 
 * ---> Create JAVA CLASS for each page of the application ---> Inspect the
 * elements and store the values ---> Create the class constructor ---> Create
 * the methods
 * 
 * ---> DONT FORGET ***** EACH PAGE CLASS SHOULD INHERIT CommonUI Class
 * ******************* ---> DONT FORGET ***** DECLARE PAGE CLASS OBJECT in
 * CONSTANTS CLASS ******************* ---> DONT FOGET ***** INITIALIZE PAGE
 * CLASS OBJECTS IN ObjInitialize JAVA ClASS ******************* ---> DONT FOGET
 * ***** CHANGE JAVA VERSION TO 1.8 *******************
 * 
 * 
 * 
 * ---> For each test case create a method then call those methods from main
 * method. ---> DONT FORGET ***** Refer to the INSTRUCTION PDF file for the test
 * cases to automate **************
 * 
 * ---> ONCE FINISHED AUTOMATING Create Repository in GitHub and push to GitHub
 * ---> Once pushed add US to the project then send picture in MENTORS GROUP
 * CHAT Crystal: --> Koritzerc23@gmail.com Helen: --> Hnbehining@gmail.com
 * Ahmad: --> a.stanikzai77@gmail.com Fahim: --> NTKBatch5
 * 
 * 
 */
