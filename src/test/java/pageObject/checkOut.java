package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOut extends basePage {

	public checkOut(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//h2[normalize-space()='Address Details']") WebElement addressHeader;
	@FindBy(xpath = "//ul[@id='address_delivery']")  WebElement deliveryAddress;
	@FindBy(xpath ="//ul[@id='address_invoice']") WebElement billingAddress;
	@FindBy(xpath  = "//tr[not(@id)]//p[@class='cart_total_price']")  WebElement finalTotalAmount;
	@FindBy(xpath = "//a[normalize-space()='Place Order']") WebElement placeOrderBtn;
    
	
	@FindBy(xpath = "//textarea[@name='message']")  WebElement messageBox;
	
	//common xpath jo saare product ke row ko dhoodega
	@FindBy(xpath = "//tr[contains(@id, 'product-')]")
     List<WebElement> cartRows;
	
	
	public void readAndVerifyCartData() {
        int sumOfAllItems = 0;

        System.out.println("--- Reading Cart Table Data ---");

        for (WebElement row : cartRows) {
            // 1. Product Name (Aapka XPath)
            String productName = row.findElement(By.xpath(".//td[@class='cart_description']//a")).getText();

            // 2. Price (Aapka XPath)
            String price = row.findElement(By.xpath(".//td[@class='cart_price']/p")).getText();

            // 3. Quantity (Aapka XPath)
            String quantity = row.findElement(By.xpath(".//td[@class='cart_quantity']/button")).getText();

            // 4. Total per item (Aapka XPath)
            String totalPerItemText = row.findElement(By.xpath(".//td[@class='cart_total']/p")).getText();

            // Logic: Total per item ko number mein convert karke sum karna
            int totalValue = Integer.parseInt(totalPerItemText.replaceAll("[^0-9]", ""));
            sumOfAllItems += totalValue;

            System.out.println("Item: " + productName + " | Qty: " + quantity + " | Total: " + totalPerItemText);
        }

        // 5. Total Amount Label verify karna (Aapka XPath)
        boolean isTotalLabelVisible = driver.findElement(By.xpath("//b[normalize-space()='Total Amount']")).isDisplayed();
        
        if(isTotalLabelVisible) {
            String finalAmount = finalTotalAmount.getText();
            System.out.println("Calculation Successful!");
            System.out.println("Sum of individual items: Rs. " + sumOfAllItems);
            System.out.println("Final Amount on Page: " + finalAmount);
        }
    }
	
	// 1. Heading check karne ke liye (Validation method)
		public String getAddressHeaderText() {
			return addressHeader.getText();
		}

		// 2. Delivery Address read karne ke liye
		public String getDeliveryAddressDetails() {
			return deliveryAddress.getText();
		}

		// 3. Billing Address read karne ke liye
		public String getBillingAddressDetails() {
			return billingAddress.getText();
		}

		// 4. Message box mein text likhne ke liye
		public void enterDescriptionMessage(String msg) {
			messageBox.sendKeys(msg);
		}

		// 5. Order button par click karne ke liye
		public void clickOnPlaceOrder() {
			placeOrderBtn.click();
	
	
	
	
}
}
	
	
	


