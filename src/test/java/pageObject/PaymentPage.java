package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends basePage {

	public PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@name='name_on_card']")
     WebElement nameOnCardField;

    @FindBy(xpath = "//input[@name='card_number']")
     WebElement cardNumberField;

    @FindBy(xpath = "//input[@placeholder='ex. 311']")
     WebElement cvcField;

    @FindBy(xpath = "//input[@placeholder='MM']")
     WebElement expiryMonthField;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
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
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(submitButton));
        

        button.click();
    }
	

}
