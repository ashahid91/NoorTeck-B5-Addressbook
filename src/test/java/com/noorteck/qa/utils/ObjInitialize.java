package com.noorteck.qa.utils;

import com.noorteck.qa.pages.Addresses;
import com.noorteck.qa.pages.HomePage;
import com.noorteck.qa.pages.SignInPage;
import com.noorteck.qa.pages.SignUpPage;

public class ObjInitialize extends Constants {
	
	 
	
	public static  void initializeClassObj() {
		addressesObj = new Addresses();
		homePageObj= new HomePage();
		signInPageObj= new SignInPage();
		signUpPageObj= new SignUpPage();
	}

}
