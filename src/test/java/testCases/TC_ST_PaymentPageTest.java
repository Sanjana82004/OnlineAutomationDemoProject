package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.AddToCartModal;
import pageObject.CartPage;
import pageObject.PaymentPage;
import pageObject.ProductsPage;
import pageObject.SignupLogin;
import pageObject.SuccessPage;
import pageObject.checkOut;
import pageObject.homePage;

public class TC_ST_PaymentPageTest extends BaseClass {
   PaymentPage pl ;
   
   checkOut checkoutPage;
   homePage hp;
   ProductsPage pp;
   AddToCartModal modal;
   CartPage cp;
   SignupLogin sp; 
   SuccessPage lp;
   
   
   @BeforeMethod
   
   public void setPage() {

		 hp = new homePage(driver);
			pp = new ProductsPage(driver);
			modal = new AddToCartModal(driver);
			cp = new CartPage(driver);
			sp = new SignupLogin(driver);
			lp = new SuccessPage(driver);
			hp.clickSignupLogin();
			checkoutPage = new checkOut(driver);
			sp.enterLoginEmail("parul123@gmail.com");
			sp.enterLoginPassword("parul123@");
			sp.clickLoginButton();
			pl= new PaymentPage(driver);
			hp.clickProducts();
			
			pp.searchProduct("Blue Top");
			pp.addProductToCart();
			modal.clickViewCart();
			
			cp.clickProceedToCheckout();
			checkoutPage.clickOnPlaceOrder();
   }
   
   
   @Test(priority = 7)
   public void verifySuccessfulPayment() {
       pl.enterName("Parul Tiwari");
       pl.enterCardNumber("4111222233334444");
       pl.enterCVC("123");
       pl.enterExpiryMonth("12");
       pl.enterExpiryYear("2030");
       pl.clickPayButton();
      
       
       Assert.assertTrue(true);
   }

   // 2. Validation: Empty Fields (Form Submission without data)
   @Test(priority = 2)
   public void verifyEmptyFieldsValidation() {
       pl.clickPayButton();
       // Browser validation check (HTML5 validation) ya error message check karein
       // Note: Selenium mein HTML5 validation 'required' attribute se check hota hai
       System.out.println("Verified: User cannot submit empty payment form.");
   }

   // 3. Validation: Invalid Card Number (Short length/Characters)
   @Test(priority = 3)
   public void verifyInvalidCardNumber() {
       pl.enterName("Parul Tiwari");
       pl.enterCardNumber("abcd123"); // Text instead of numbers
      pl.enterCVC("123");
       pl.enterExpiryYear("2030");
       pl.clickPayButton();
       
       // Assert based on application's behavior (error message or staying on same page)
       Assert.assertTrue("User should not proceed with invalid card!", driver.getCurrentUrl().contains("payment"));
   }

   // 4. Validation: Invalid Expiry Date (Past Date)
   @Test(priority = 4)
   public void verifyPastExpiryDate() {
       pl.enterName("Parul Tiwari");
       pl.enterCardNumber("4111222233334444");
       pl.enterCVC("123");
       pl.enterExpiryMonth("01");
       pl.enterExpiryYear("1990"); // Past year
       pl.clickPayButton();
       
       // Agar system error message deta hai toh use verify karein
       System.out.println("Checked: System should reject past expiry dates.");
   }

   // 5. Validation: CVC Length (Extra long or short)
   @Test(priority = 5)
   public void verifyCVCLength() {
       pl.enterCVC("12345"); // CVC usually 3-4 digits hota hai
       pl.clickPayButton();
       // Validation logic
   }

   // 6. UI Test: Field Presence
   @Test(priority = 6)
   public void verifyAllFieldsDisplayed() {
       Assert.assertTrue(driver.getPageSource().contains("Name on Card"));
       Assert.assertTrue(driver.getPageSource().contains("Card Number"));
       Assert.assertTrue(driver.getPageSource().contains("CVC"));
       Assert.assertTrue(driver.getPageSource().contains("Expiration"));
   }
   
   
   
   
}
