package testCases;


import org.testng.annotations.Test;
import utilities.RandomDataGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.RegistrationPage;
import pageObject.SignupLogin;
import pageObject.homePage;

public class TC_ST_RegistrationTest extends BaseClass {

	SignupLogin sp; 
	homePage hp; 
	RegistrationPage rp;
	
@BeforeMethod
	
	public void setupPageObjects() {
		sp = new SignupLogin(driver);
        hp = new homePage(driver);
        rp = new RegistrationPage(driver);
        
       
	}
	
@Test	
public void registrationPractice() {
	 hp.clickSignupLogin();
  	sp.enterSignupName(RandomDataGenerator.getRandomString());
  	sp.enterSignupEmail(RandomDataGenerator.getRandomString().toLowerCase()+ "@gmail.com");
  	sp.clickSignupButton();
  	rp.enterPassword(RandomDataGenerator.getRandomYear());
  	rp.selectGenderMrs();
	rp.enterFirstName(RandomDataGenerator.getRandomString());
  	rp.enterLastName(RandomDataGenerator.getRandomString());
  	rp.enterCompany(RandomDataGenerator.getRandomString());
  	rp.enterAddress1(RandomDataGenerator.getRandomString());
  	rp.enterAddress2(RandomDataGenerator.getRandomString());
  	rp.selectCountry("Australia");
  	rp.enterState("Madhya pradesh");
  	rp.enterCity("bhopal");
  	rp.enterZipcode("462022");
  	rp.enterMobileNumber(RandomDataGenerator.getRandomNumber(10));
  	
  	rp.clickNewsletter();
  	rp.clickSpecialOffers();
  	rp.enterPassword(RandomDataGenerator.getRandomNumber(6));
  	
  	rp.selectDay(RandomDataGenerator.getRandomDay());
  	rp.selectMonth(RandomDataGenerator.getRandomMonth());
  	rp.clickCreateAccountButton();
  	rp.clickContinueButton();
  	
}

	
}
