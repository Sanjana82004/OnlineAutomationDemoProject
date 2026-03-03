package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pageObject.AddToCartModal;
import pageObject.ProductsPage;
import pageObject.homePage;

public class TC_ST_AddToCartTest extends BaseClass
{
	
	homePage hp;
	ProductsPage pp;
	AddToCartModal modal;
	
	@BeforeMethod
	
	public void setupSteps() {
		hp = new homePage(driver);
		pp = new ProductsPage(driver);
		modal = new AddToCartModal(driver);
		hp.clickProducts();
		pp.addProductToCart();
	}
	
	
	
	@Test(priority = 1)
	
	public void testModalDisplayAndMessage() {
		
		logger.info("testing priotity 1");
		Assert.assertTrue(modal.isModalDisplayed());
		
		String successText = modal.getAddedMessageText();
		Assert.assertEquals(successText, "Added!", "modal par success message galat hai!");
	}
	
	
	@Test(priority = 2)
	
	public void testViewCartNavigation() {
		logger.info("testing priotity 2");
		modal.clickViewCart();	
		String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/view_cart"));
	}
	
	
	@Test(priority = 3)
    public void testContinueShoppingFunctionality() {
		logger.info("testing priotity 3");
        modal.clickContinueShopping();
        
        // Verify karein ki modal band ho gaya hai
        // Note: Modal band hone par isDisplayed() exception de sakta hai, isliye visibility check karein
        try {
            boolean isVisible = modal.isModalDisplayed();
            Assert.assertFalse(isVisible);
        } catch (Exception e) {
            // Agar element DOM se hat gaya hai, toh iska matlab modal band ho gaya hai (Pass)
            Assert.assertTrue(true);
        }
    }
	
	@Test(priority = 4)
    public void testSuccessTitleVisibility() {
		logger.info("testing priotity 4");
        Assert.assertTrue(modal.isAddedMessageVisible());
    }
	

}
