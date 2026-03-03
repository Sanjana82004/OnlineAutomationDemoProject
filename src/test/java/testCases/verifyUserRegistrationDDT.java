package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.RegistrationPage;
import pageObject.SignupLogin;
import pageObject.homePage;
import utilities.dataProviders;

public class verifyUserRegistrationDDT extends BaseClass {
	
	homePage hp;
    SignupLogin auth;
    RegistrationPage reg;
    
    
    @BeforeMethod
    public void init() {
        hp = new homePage(driver);
        auth = new SignupLogin(driver);
        reg = new RegistrationPage(driver);
        
        
    }


    @Test(dataProvider = "RegistrationData", dataProviderClass = dataProviders.class)
    public void verifyUserRegistration(
            String name,
            String email,
            String password,
            String gender,
            String day,
            String month,
            String year,
            String firstName,
            String lastName,
            String address,
            String country,
            String state,
            String city,
            String zip,
            String mobile) {

        // Optional but recommended: avoid duplicate email failure
        email = email + System.currentTimeMillis();

        hp.clickSignupLogin();

        auth.enterSignupName(name);
        auth.enterSignupEmail(email);
        auth.clickSignupButton();

        if (gender.equalsIgnoreCase("Mr")) {
            reg.selectGenderMr();
        } else {
            reg.selectGenderMrs();
        }

        reg.enterPassword(password);
        reg.selectDay(day);
        reg.selectMonth(month);
        reg.selectYear(year);

        reg.enterFirstName(firstName);
        reg.enterLastName(lastName);
        reg.enterAddress1(address);
        reg.selectCountry(country);
        reg.enterState(state);
        reg.enterCity(city);
        reg.enterZipcode(zip);
        reg.enterMobileNumber(mobile);

        reg.clickCreateAccountButton();

        Assert.assertTrue(
                driver.getPageSource().contains("Account Created"),
                "Account creation failed"
        );

        reg.clickContinueButton();
        hp.clickLogout();
    }
}