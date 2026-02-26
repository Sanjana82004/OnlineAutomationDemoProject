package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends basePage {

	public PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "(//div[@class='col-md-12 form-group'])[1]//input")
     WebElement nameOnCardField;

    @FindBy(xpath = "(//div[@class='col-md-12 form-group'])[2]//input")
     WebElement cardNumberField;

    @FindBy(xpath = "(//div[@class='col-md-12 form-group'])[3]//input")
     WebElement cvcField;

    @FindBy(xpath = "(//div[@class='col-md-12 form-group'])[4]//input")
     WebElement expiryMonthField;

    @FindBy(xpath = "(//div[@class='col-md-12 form-group'])[5]//input")
     WebElement expiryYearField;
    
    @FindBy(xpath = "//button[@id='submit']")
     WebElement submitButton;
    
    public void enterName(String name) {
        nameOnCardField.clear();
        nameOnCardField.sendKeys(name);
    }

    public void enterCardNumber(String number) {
        cardNumberField.clear();
        cardNumberField.sendKeys(number);
    }

    public void enterCVC(String cvc) {
        cvcField.clear();
        cvcField.sendKeys(cvc);
    }

    public void enterExpiryMonth(String mm) {
        expiryMonthField.clear();
        expiryMonthField.sendKeys(mm);
    }

    public void enterExpiryYear(String yyyy) {
        expiryYearField.clear();
        expiryYearField.sendKeys(yyyy);
    }

    public void clickPayButton() {
    	utils.waitForElementClickable(submitButton, 10);
    	submitButton.click();
    }
	

}
