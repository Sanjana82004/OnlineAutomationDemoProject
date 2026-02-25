package pageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewProductPage extends basePage {

    public ViewProductPage(WebDriver driver) {
        super(driver);
    }

    // ---------- PRODUCT IMAGE ----------
    @FindBy(xpath = "//div[@class='view-product']//img[@alt='ecommerce website products']")
    private WebElement productImage;


    // ---------- PRODUCT NAME ----------
    @FindBy(css = "div[class='product-information'] h2")
    private WebElement productName;


    // ---------- CATEGORY ----------
    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[1]")
    private WebElement categoryText;


    // ---------- PRICE ----------
    @FindBy(css = "div[class='product-information'] span span")
    private WebElement productPrice;


    // ---------- QUANTITY ----------
    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement quantityInput;


    // ---------- ADD TO CART ----------
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToCartBtn;


    // ---------- AVAILABILITY ----------
    @FindBy(xpath = "//div[@class='product-details']//p[2]")
    private WebElement availabilityText;


    // ---------- CONDITION ----------
    @FindBy(xpath = "//body//section//p[3]")
    private WebElement conditionText;


    // ---------- BRAND ----------
    @FindBy(xpath = "//body//section//p[4]")
    private WebElement brandText;



    // =========================================================
    //                    ACTION METHODS
    // =========================================================


    // IMAGE DISPLAY CHECK
    public boolean isProductImageDisplayed() {
        return productImage.isDisplayed();
    }


    // PRODUCT NAME
    public String getProductName() {
        return productName.getText();
    }


    // CATEGORY
    public String getCategory() {
        return categoryText.getText();
    }


    // PRICE
    public String getPrice() {
        return productPrice.getText();
    }


    // QUANTITY ACTIONS
    public void clearQuantity() {
        quantityInput.clear();
    }

    public void enterQuantity(String qty) {
        quantityInput.clear();
        quantityInput.sendKeys(qty);
    }

    public String getQuantity() {
        return quantityInput.getAttribute("value");
    }


    // ADD TO CART
    public void clickAddToCart() {
        addToCartBtn.click();
    }


    // PRODUCT DETAILS
    public String getAvailability() {
        return availabilityText.getText();
    }

    public String getCondition() {
        return conditionText.getText();
    }

    public String getBrand() {
        return brandText.getText();
    }



  

}