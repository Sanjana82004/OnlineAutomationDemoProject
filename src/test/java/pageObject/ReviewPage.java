package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends basePage {

    public ReviewPage(WebDriver driver) {
        super(driver);
    }

    // ---------- INPUT FIELDS ----------
    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//textarea[@id='review']")
    private WebElement reviewTextArea;


    // ---------- SUBMIT BUTTON ----------
    @FindBy(xpath = "//button[@id='button-review']")
    private WebElement submitBtn;



    // =========================================================
    //                    ACTION METHODS
    // =========================================================


    // NAME
    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }



    // EMAIL
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

   

    // REVIEW MESSAGE
    public void enterReview(String review) {
        reviewTextArea.clear();
        reviewTextArea.sendKeys(review);
    }

    


    // SUBMIT
    public void clickSubmit() {
        submitBtn.click();
    }



    // =========================================================
    //              COMPOSITE BUSINESS METHODS
    // =========================================================

    public void submitReview(String name, String email, String review) {
        enterName(name);
        enterEmail(email);
        enterReview(review);
        clickSubmit();
    }


}