package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupLogin {

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
