package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends basePage{

    WebDriver driver;

    public CartPage(WebDriver driver){
        super(driver);
    }

    // all rows of cart
    @FindBy(xpath = "//tbody/tr")
     List<WebElement> cartRows;


    @FindBy(xpath = "//ol[@class='breadcrumb']//a[normalize-space()='Home']")
    WebElement homeBtn;

    
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
     WebElement proceedToCheckoutBtn;

    // ---------- ACTION METHODS ----------

    public int getItemCount(){
        return cartRows.size();
    }

    public CartItemComponent getItem(int index){
        return new CartItemComponent(driver, cartRows.get(index));
    }

    public List<CartItemComponent> getAllItems(){
        List<CartItemComponent> items = new ArrayList<>();

        for(WebElement row : cartRows){
            items.add(new CartItemComponent(driver,row));
        }
        return items;
    }

    public void clickHome(){
        homeBtn.click();
    }
    
    public void clickProceedToCheckout() {
        // Pehle scroll karein taaki button dikhne lage
        utils.scrollToElement(proceedToCheckoutBtn);
        
        // Wait karein ki button clickable hai ya nahi
        utils.waitForElementClickable(proceedToCheckoutBtn, 10);
        
        try {
            proceedToCheckoutBtn.click();
        } catch (Exception e) {
            // Agar normal click fail ho (overlay/ads ki wajah se), toh JS click use karein
            utils.jsClick(proceedToCheckoutBtn);
        }
    }
    
   
    
    }
