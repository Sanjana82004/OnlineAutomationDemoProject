package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.ProductsPage;
import pageObject.homePage;

public class TC_ST_ProductTest extends BaseClass {

	homePage hp;
    ProductsPage pp;

    @BeforeMethod
    public void setupPageObjects() {
        // Har test se pehle page objects ko initialize karein
        hp = new homePage(driver);
        pp = new ProductsPage(driver);
        
        // Products page par jana har test ki basic requirement hai
        hp.clickProducts(); 
    }

    // 1. Verify All Products Page Load
    @Test(priority = 1)
    public void verifyAllProductsLoad() {
        String actualTitle = pp.getFilterTitle();
        // Check karein ki Default Title 'ALL PRODUCTS' hai ya nahi
        Assert.assertEquals(actualTitle, "ALL PRODUCTS", "All Products page load nahi hua!");
        System.out.println("Test 1: All Products page load verified.");
    }

    // 2. Verify Product Search Functionality
    @Test(priority = 2)
    public void verifyProductSearch() {
        String productName = "Blue Top";
        pp.searchProduct(productName);
        
        // Search ke baad title check karein
        String searchTitle = pp.getFilterTitle();
        Assert.assertEquals(searchTitle, "SEARCHED PRODUCTS", "Search title mismatch!");
        
        // Ensure karein ki product screen par dikh raha hai
        Assert.assertTrue(driver.getPageSource().contains(productName), "Searched product not found!");
        System.out.println("Test 2: Product Search for '" + productName + "' passed.");
    }

    // 3. Verify Category Filter (Women -> Dress)
    @Test(priority = 3)
    public void verifyCategoryFilter() {
        // Step 1: Women section expand karein
        pp.openWomenSection();
        try { Thread.sleep(1000); } 
        catch (InterruptedException e) 
        { e.printStackTrace();
        }
        
        // Step 3: Dress select karein (Ab ye JS click use karega)
        pp.selectWomenDress();
        
        // Step 4: Verification
        String actualFilterTitle = pp.getFilterTitle();
        Assert.assertTrue(actualFilterTitle.equalsIgnoreCase("WOMEN - DRESS PRODUCTS"), 
                "Category filter mismatch! Found: " + actualFilterTitle);
       
        
    }
	
}
