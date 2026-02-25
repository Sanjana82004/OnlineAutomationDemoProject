package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    // 3. Action Methods (Re-usable functions)

    public void clickProducts() {
        productsLink.click();
    }

    public void clickSignupLogin() {
        signupLoginLink.click();
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
	

}
