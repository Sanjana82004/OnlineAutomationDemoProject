package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.homePage;

public class TC_ST_homePageTest extends BaseClass {
   
	homePage hp;

    @BeforeMethod
    public void setupPage() {
        // Driver initialize hone ke baad object banana
        hp = new homePage(driver);
    }
	
    @Test(priority = 1)
    public void verifyLogoVisibility() {
        boolean logoStatus = hp.isLogoDisplayed();
        Assert.assertTrue(logoStatus, "Error: Website logo Home Page par visible nahi hai!");
       
    }
    
    
    @Test(priority = 2)
    public void verifyNavbarNavigation() {
        // Products Page check
        hp.clickProducts();
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"), "Navigation to Products failed!");
        
        // Signup/Login Page check
        hp.clickSignupLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Navigation to Login failed!");
        
        // Contact Us check
        hp.clickContactUs();
        Assert.assertTrue(driver.getCurrentUrl().contains("/contact_us"), "Navigation to Contact Us failed!");
        
        System.out.println("Navbar navigation check passed.");
    }
    
    
    @Test(priority = 3)
    public void verifySubscription() {
        String testEmail = "tester_rahul@test.com";
        hp.subscribeToNewsletter(testEmail);
        
        // Success message verify karna
        String actualMsg = hp.getSubscriptionSuccessMessage();
        String expectedMsg = "You have been successfully subscribed!";
        
        Assert.assertEquals(actualMsg, expectedMsg, "Subscription message mismatch!");
        System.out.println("Subscription test passed.");
    }
    
    @Test(priority = 4)
    public void verifyScrollUpFunctionality() {
        // Pehle footer tak scroll karna (Subscription method already karta hai)
        hp.subscribeToNewsletter("scroll@test.com");
        
        // Scroll Up check karne ke liye hum check kar sakte hain ki header/logo wapas visible hai ya nahi
        // Isme hum Javascript ka use karke top par ja sakte hain agar alag se arrow button ka locator na ho
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)"); // Top par scroll karna
     
        Assert.assertTrue(hp.isLogoDisplayed(), "Scroll Up ke baad logo visible nahi hua!");
        System.out.println("Scroll Up check passed.");
    }
    
    
	
}
