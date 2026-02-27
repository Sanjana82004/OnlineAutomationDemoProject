package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage extends basePage
{

	public homePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//a[@href='/products']")
     WebElement productsLink;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
     WebElement signupLoginLink;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
     WebElement testCasesLink;

    @FindBy(xpath = "//a[normalize-space()='API Testing']")
     WebElement apiTestingLink;

    @FindBy(xpath = "//a[normalize-space()='Video Tutorials']")
     WebElement videoTutorialsLink;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
     WebElement contactUsLink;

    @FindBy(xpath = "//img[@alt='Website for automation practice']")
     WebElement logo;
    
    
 // Subscription Email Input
    @FindBy(xpath = "//input[@id='susbscribe_email']")
     WebElement subscribeEmailInput;
    
    
  @FindBy(xpath ="//a[normalize-space()='Logout']") WebElement logout;
  
  
  @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
   WebElement subscribeArrowBtn;

  // Success Message (for verification)
  @FindBy(id = "success-subscribe")
   WebElement successAlert;
  

  @FindBy(xpath= "//li[10]//a[1]")
  WebElement loggedinMessage;
  
  
  

    // 3. Action Methods (Re-usable functions)

    public void clickProducts() {
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Pehle click karo
        utils.jsClick(productsLink);
        
        // Click ke baad wait karo ki URL badal jaye
        wait.until(ExpectedConditions.urlContains("/products"));
    	
    	
       
    }

    public void clickSignupLogin() {
        signupLoginLink.click();
    }
    public boolean SignupLoginDisplayed() {
        return signupLoginLink.isDisplayed();
    }

    public void clickTestCases() {
        testCasesLink.click();
    }

    public void clickApiTesting() {
        apiTestingLink.click();
    }

    public void clickContactUs() {
        contactUsLink.click();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }
    
    public void clickLogout() {
    	logout.click();
    }
    
    public void subscribeToNewsletter(String email) {
        // Footer tak scroll karna zaroori hai taaki element visible ho
       utils.scrollToElement(subscribeEmailInput);
        
        subscribeEmailInput.clear();
        subscribeEmailInput.sendKeys(email);
       utils.jsClick(subscribeArrowBtn);
    }
    
    public String getSubscriptionSuccessMessage() {
        return successAlert.getText();
    }
    public String getLoggedInmessage() {
    	return loggedinMessage.getText();
    }
    
	

}
