package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
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
		hp.clickProducts();
		pp.addProductToCart();
		modal.clickViewCart();
		
		cp.clickProceedToCheckout();
		
		sp.enterLoginEmail("rinku");
		sp.enterLoginPassword("rinku123@gmail.com");
		sp.clickLoginButton();
		
  }
  
  @Test(priority = 1)
  public void verifyCheckoutPageUI()
  {
	   String headerText = checkoutPage.getAddressHeaderText();
	   Assert.assertEquals(headerText, "Address Details", "header mismatch!");
  }
  @Test(priority = 2)
  
  public void verifyAddressConsistency() {
	String delivery = checkoutPage.getDeliveryAddressDetails() ;
	String biling = checkoutPage.getBillingAddressDetails();
	Assert.assertEquals(delivery, biling, "delivery and billing address are not identical!");
  }
  
@Test(priority = 3)
public void verifyCartCalculation() {
	
	checkoutPage.readAndVerifyCartData();
	boolean isTotalVisible = driver.getPageSource().contains("Total Amount");
    Assert.assertTrue(isTotalVisible);
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


