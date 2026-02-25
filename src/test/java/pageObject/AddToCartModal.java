package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartModal extends basePage {

    public AddToCartModal(WebDriver driver) {
        super(driver);
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
        return modalContainer.isDisplayed();
    }

    public boolean isAddedMessageVisible() {
        return addedTitle.isDisplayed();
    }

    public String getAddedMessageText() {
        return addedTitle.getText();
    }


   

    public void clickViewCart() {
        viewCartLink.click();
    }

    public void clickContinueShopping() {
        continueShoppingBtn.click();
    }


    
}