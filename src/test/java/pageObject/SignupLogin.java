package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupLogin extends basePage {

	public SignupLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@data-qa='login-email']")
     WebElement loginEmailInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement loginPasswordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginBtn;

    // Signup Section
    @FindBy(xpath = "//input[@placeholder='Name']")
     WebElement signupNameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
     WebElement signupEmailInput;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
     WebElement signupBtn;
    
  @FindBy(xpath ="//p[normalize-space()='Your email or password is incorrect!']")  WebElement loginError;
    
  //body


    // --- 3. Individual Action Methods ---

    // Login Methods
    public void enterLoginEmail(String email) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        loginPasswordInput.clear();
        loginPasswordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }
    
    public String getErrorLogin() {
    	utils.waitForElementVisible(loginError,  10);
    	return loginError.getText();
    }

    // Signup Methods
    public void enterSignupName(String name) {
        signupNameInput.clear();
        signupNameInput.sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        signupEmailInput.clear();
        signupEmailInput.sendKeys(email);
    }

    public void clickSignupButton() {
        signupBtn.click();
    }
    
    // Check if Page is Loaded
    public boolean isLoginPageDisplayed() {
        return loginBtn.isDisplayed();
    }
	
	
}
