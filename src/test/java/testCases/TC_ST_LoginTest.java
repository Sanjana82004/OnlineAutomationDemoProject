package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.SignupLogin;
import pageObject.homePage;

public class TC_ST_LoginTest extends BaseClass{

	SignupLogin sp; 
	homePage hp; 
	
	
	@BeforeMethod
	
	public void setupPageObjects() {
		sp = new SignupLogin(driver);
        hp = new homePage(driver);
	}
	
	@Test(priority = 1)
	
	public void testNewUserSignup() {
	
		
		hp.clickSignupLogin();
		sp.enterSignupName("parul");
		sp.enterSignupEmail("parul123@gmail.com");
		sp.clickSignupButton();
		Assert.assertTrue(driver.getTitle().contains("Signup"), "Signup page was not displayed!");
	}
	
	@Test(priority = 2)
	public void verifyValidLogin() {
		hp.clickSignupLogin();
		sp.enterLoginEmail("rinku123@gmail.com");
		sp.enterLoginPassword("rinku123@");
		sp.clickLoginButton();
		Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise"), "Login failed!");	
		
	}
	
	@Test(priority = 3)
	
	public void verifyInvalidLogin() {
		hp.clickSignupLogin();
		sp.enterLoginEmail("rinku123");
		sp.enterLoginPassword("rinku123@");
		sp.clickLoginButton();
		String actual = sp.getErrorLogin();
		String expected = "Your email or password is incorrect!";
		Assert.assertEquals(actual, expected, "Error message mismatch!");
		
	}
	
	@Test(priority = 4)
	
	public void verifyLogout() {
		hp.clickSignupLogin();
		sp.enterLoginEmail("rinku123@gmail.com");
	    sp.enterLoginPassword("rinku123@");
	    sp.clickLoginButton();
	    
	    hp.clickLogout();
	    boolean isLoginVisible = sp.isLoginPageDisplayed();
	    Assert.assertTrue(isLoginVisible, "Logout fail ho gaya: Login page nahi dikha!");
	    
	    
	}
	
	
}
