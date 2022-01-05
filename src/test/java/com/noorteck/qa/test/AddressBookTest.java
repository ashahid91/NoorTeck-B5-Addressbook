package com.noorteck.qa.test;

import org.testng.asserts.SoftAssert;

import com.noorteck.qa.pages.Addresses;
import com.noorteck.qa.pages.HomePage;
import com.noorteck.qa.pages.SignInPage;
import com.noorteck.qa.pages.SignUpPage;
import com.noorteck.qa.utils.CommonUI;
import com.noorteck.qa.utils.ObjInitialize;

public class AddressBookTest extends ObjInitialize {

	public static void main(String[] args) {
		String url = "http://a.testaddressbook.com/sign_up";

		CommonUI.openBrowser("chrome");
		AddressBookTest testObj = new AddressBookTest();

		testObj.initializeClassObj();
//		CommonUI.navigate(url);
//		testObj.testCaseOne();
//		CommonUI.quitBrowser();
		url = "http://a.testaddressbook.com/sign_in";
		CommonUI.openBrowser("chrome");
		CommonUI.navigate(url);
		testObj.testCaseTwo();

		CommonUI.quitBrowser();

	}

	public void testCaseOne() {
		SignUpPage signUpPageObj = new SignUpPage();
		signUpPageObj.enterEmail("chicken.biryani1@gmail.com");
		signUpPageObj.enterPassword("aloobukhara");
		signUpPageObj.clickSignUp();
		HomePage homePageObj = new HomePage();
		String welcomeMessage = homePageObj.welcomeTitke();
		String expectedMessage = "Welcome to Address Book";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(welcomeMessage, expectedMessage);
	}

	public void testCaseTwo() {

		SignInPage signInObj = new SignInPage();

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
		SoftAssert softAssert = new SoftAssert();
		String expectedFirstName= "Elon";
		String expectedLasTName= "Musk";
		String expectedCity= "Reston";
		String expectedState= "Virgina";
		String actualFirstName= addressesObj.getFirstNameData();
		String actualLastName= addressesObj.getLastNameData();
		String actualCity= addressesObj.getCityData();
		String actualState= addressesObj.getStateData();
		
		softAssert.assertEquals(expectedFirstName, actualFirstName);
		softAssert.assertEquals(expectedLasTName,actualLastName);
		softAssert.assertEquals(expectedCity,actualCity);
		softAssert.assertEquals(expectedState,actualState);
		softAssert.assertAll();
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
