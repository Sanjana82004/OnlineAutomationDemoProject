package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends basePage {

	public SuccessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//b[normalize-space()='Order Placed!']")
     WebElement orderPlacedText;

    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
     WebElement confirmationMessage;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
     WebElement downloadInvoiceBtn;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
     WebElement continueBtn;
    
    
    public String getConfirmationHeading() {
        return orderPlacedText.getText();
    }
    
    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public void clickDownloadInvoice() {
        downloadInvoiceBtn.click();
    }

    public void clickContinue() {
        continueBtn.click();
    }
	

}
