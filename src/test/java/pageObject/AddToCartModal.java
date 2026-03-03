package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartModal extends basePage {
    public WebDriverWait wait;
    public AddToCartModal(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- MODAL CONTAINER ----------
    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement modalContainer;


    // ---------- ADDED MESSAGE TITLE ----------
    @FindBy(xpath = "//h4[normalize-space()='Added!']")
    private WebElement addedTitle;


    // ---------- VIEW CART LINK ----------
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement viewCartLink;


    // ---------- CONTINUE SHOPPING BUTTON ----------
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    private WebElement continueShoppingBtn;
    
    

    // =========================================================
    //                  ACTION METHODS
    // =========================================================



    public boolean isModalDisplayed() {
    	utils.waitForElementVisible(modalContainer, 10);
    	return modalContainer.isDisplayed();
    }

    public boolean isAddedMessageVisible() {
    	 utils.waitForElementVisible(addedTitle, 5);
    	 return addedTitle.isDisplayed();
    }

    public String getAddedMessageText() {
    	utils.waitForElementVisible(addedTitle, 5);
        return addedTitle.getText();
    }


   

    public void clickViewCart() {
    utils.waitForElementClickable(viewCartLink, 5);
        
        // Phir action perform karein
        viewCartLink.click();
    }

    public void clickContinueShopping() {
    	utils.waitForElementClickable(continueShoppingBtn, 5);
        continueShoppingBtn.click();
    }


    
}