package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;
import pageObject.AddToCartModal;
import pageObject.CartPage;
import pageObject.ProductsPage;
import pageObject.SignupLogin;
import pageObject.checkOut;
import pageObject.homePage;

public class TC_ST_checkoutTest extends BaseClass{

 checkOut checkoutPage;
 homePage hp;
 ProductsPage pp;
 AddToCartModal modal;
 CartPage cp;
 SignupLogin sp; 
 
 
  @BeforeClass
  public void setupPage() {
	 checkoutPage = new checkOut(driver) ;
	 
	 hp = new homePage(driver);
		pp = new ProductsPage(driver);
		modal = new AddToCartModal(driver);
		cp = new CartPage(driver);
		sp = new SignupLogin(driver);
		hp.clickSignupLogin();
		
		sp.enterLoginEmail("parul123@gmail.com");
		sp.enterLoginPassword("parul123@");
		sp.clickLoginButton();
		
		hp.clickProducts();
		
		pp.searchProduct("Blue Top");
		pp.addProductToCart();
		modal.clickViewCart();
		
		cp.clickProceedToCheckout();
		
		
		
  }
  
  @Test(priority = 1)
  public void verifyCheckoutPageUI()
  {
	   String headerText = checkoutPage.getAddressHeaderText().trim();
	   String expectedHeader = "Address Details";
	   Assert.assertEquals(headerText, expectedHeader, "header mismatch!");
  }
  @Test(priority = 2)
  
  public void verifyAddressConsistency() {
	String delivery = checkoutPage.getDeliveryAddressDetails() ;
	String biling = checkoutPage.getBillingAddressDetails();
	Assert.assertTrue(delivery.contains("Mrs. parul Tiwari")&& biling.contains("Mrs. parul Tiwari"), "Name  mismatch!");
  }
  
@Test(priority = 3)
public void verifyCartCalculation() {
	
	checkoutPage.readAndVerifyCartData();
	boolean isTotalVisible = driver.getPageSource().contains("Total Amount");
    Assert.assertTrue(isTotalVisible,"total amount label not found on page!");
}

@Test(priority = 4)
public void verifyOrderCommentsInput() {
    System.out.println("Test 4: Entering Order Comments...");
    String myMsg = "Handle with care, fragile item inside.";
    checkoutPage.enterDescriptionMessage(myMsg);
    
    // Note: Yahan hum verify kar rahe hain ki textarea clickable aur editable hai
   
}


@Test(priority = 5)
public void verifyPlaceOrderNavigation() {
   
    checkoutPage.clickOnPlaceOrder();
    
    // URL validation to ensure we moved to the next step
    String currentUrl = driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("payment"));
    
}

}


