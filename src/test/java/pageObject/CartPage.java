package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // all rows of cart
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> cartRows;


    @FindBy(xpath = "//ol[@class='breadcrumb']//a[normalize-space()='Home']")
    private WebElement homeBtn;


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
}
