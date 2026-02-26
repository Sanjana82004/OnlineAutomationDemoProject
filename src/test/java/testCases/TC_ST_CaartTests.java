package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


import pageObject.AddToCartModal;
import pageObject.CartItemComponent;
import pageObject.CartPage;
import pageObject.ProductsPage;
import pageObject.homePage;


public class TC_ST_CaartTests extends BaseClass {
   homePage hp;
   ProductsPage pp;
   AddToCartModal modal;
   
	CartPage cp;
	
	@BeforeMethod()
	
	public void setupPage() {
		
		hp = new homePage(driver);
		pp = new ProductsPage(driver);
		modal = new AddToCartModal(driver);
		cp = new CartPage(driver);
		hp.clickProducts();
		pp.addProductToCart();
		modal.clickViewCart();
		
	}
	
	@Test(priority = 1)
	
	public void testFirstItemDetails() {
		CartItemComponent firstItem =cp.getItem(0);
		String name = firstItem.getName();
		String price = firstItem.getPrice();
		String qty = firstItem.getQuantity();
		
		Assert.assertFalse(name.isEmpty());
		Assert.assertTrue(price.contains("Rs."));
		Assert.assertEquals(qty,  "1", "default quantity should be 1");
	}
	
	@Test(priority = 2)
	
	public void testCartTotalCalculation() {
		CartItemComponent item = cp.getItem(0);
		
		int price = Integer.parseInt(item.getPrice().replaceAll("[^0-9]", ""));
		int quantity = Integer.parseInt(item.getQuantity());
		int expectedTotal = price*quantity;
		int actualTotal = Integer.parseInt(item.getTotal().replaceAll("[^0-9]", ""));
		Assert.assertEquals(actualTotal, expectedTotal);
	}
	
	
	
	@Test(priority = 3)
	
	public void testRemoveProduct() throws InterruptedException {
		int initialCount = cp.getItemCount();
		Assert.assertTrue(initialCount >0);
		cp.getItem(0).removeItem();
		Thread.sleep(2000);
		
		int finalCount = cp.getItemCount();
		
		Assert.assertEquals(finalCount,  initialCount-1);
	}
	
	@Test(priority = 4)
	
	public void testContinueShoppingNavigation() {
		cp.clickHome();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("automationexercise"), 
		        "URL mismatch! Actual URL is: " + currentUrl);
	}
	
	
	
	
	
}
