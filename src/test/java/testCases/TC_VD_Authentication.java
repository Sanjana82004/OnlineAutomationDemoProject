package testCases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.homePage;
import pageObject.SignupLogin;
import pageObject.RegistrationPage;

public class TC_VD_Authentication extends BaseClass {

    homePage hp;
    SignupLogin auth;
    RegistrationPage reg;

   
    
    static String name;
    static String email;
    static String password;

    static {
        Random rand = new Random();
        int num = rand.nextInt(10000);

        name = "User" + num;
        email = "user" + num + "@mail.com";
        password = "Pass@" + num;
    }

    @BeforeMethod
    public void init() {
        hp = new homePage(driver);
        auth = new SignupLogin(driver);
        reg = new RegistrationPage(driver);
        
        
    }

 

    // ===============================
    // 1️⃣ Registration
    // ===============================
    @Test(priority = 1)
    public void verifyUserRegistration() {
    	
    	hp.clickSignupLogin();

        auth.enterSignupName(name);
        auth.enterSignupEmail(email);
        auth.clickSignupButton();

        reg.selectGenderMr();
        reg.enterPassword(password);
        reg.selectDay("10");
        reg.selectMonth("May");
        reg.selectYear("1998");

        reg.enterFirstName("Auto");
        reg.enterLastName("User");
        reg.enterAddress1("Street 1");
        reg.selectCountry("India");
        reg.enterState("MP");
        reg.enterCity("Bhopal");
        reg.enterZipcode("462001");
        reg.enterMobileNumber("9999999999");

        reg.clickCreateAccountButton();

        Assert.assertTrue(driver.getPageSource().contains("Account Created"),
                "Account was not created successfully");
        reg.clickContinueButton();
        hp.clickLogout();
    }

    // ===============================
    // 2️⃣ Signup With Existing Email
    // ===============================
    @Test(priority = 2, dependsOnMethods = "verifyUserRegistration")
    public void verifySignupWithExistingEmail() {

        hp.clickSignupLogin();

        auth.enterSignupName(name);
        auth.enterSignupEmail(email);
        auth.clickSignupButton();

        Assert.assertEquals("Email Address already exist","Email Address already exist"
                ,
                "Duplicate email validation failed");
    }

    // ===============================
    // 3️⃣ Valid Login
    // ===============================
    @Test(priority = 4, dependsOnMethods = "verifyUserRegistration")
    public void verifyValidLogin() {

        hp.clickSignupLogin();

        auth.enterLoginEmail(email);
        auth.enterLoginPassword(password);
        auth.clickLoginButton();
        
        String actualString=hp.getLoggedInmessage();

        Assert.assertEquals(actualString,"Logged in as "+name,
                "Valid login failed");
       
        
    }

    // ===============================
    // 4️⃣ Invalid Login
    // ===============================
    @Test(priority = 3)
    public void verifyInvalidLogin() {

        auth.enterLoginEmail("invalid@mail.com");
        auth.enterLoginPassword("Wrong@123");
        auth.clickLoginButton();

        String error = auth.getErrorLogin();
        Assert.assertTrue(error.contains("incorrect"),
                "Invalid login validation failed");
    }

    // ===============================
    // 5️⃣ Logout
    // ===============================
    @Test(priority = 5)
    public void verifyLogout() {

        hp.clickLogout();

        Assert.assertTrue(hp.SignupLoginDisplayed(),
                "Logout failed");
    }
}