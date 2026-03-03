package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends basePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//input[@id='id_gender1']")
    WebElement genderMr;

    @FindBy(xpath = "//input[@id='id_gender2']")
    WebElement genderMrs;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days']")
    WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearsDropdown;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@id='optin']")
    WebElement optinCheckbox;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='company']")
    WebElement companyInput;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement address1Input;

    @FindBy(xpath = "//input[@id='address2']")
    WebElement address2Input;

    @FindBy(xpath = "//select[@id='country']")
    WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='state']")
    WebElement stateInput;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityInput;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipcodeInput;

    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobileInput;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountBtn;
    
  
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement continuebtn;

    // --- Action Methods ---

    public void selectGenderMr() {
        genderMr.click();
    }

    public void selectGenderMrs() {
        genderMrs.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void selectDay(String dayValue) {
        Select selectDay = new Select(daysDropdown);
        selectDay.selectByVisibleText(dayValue);
    }

    public void selectMonth(String monthValue) {
        Select selectMonth = new Select(monthsDropdown);
        selectMonth.selectByVisibleText(monthValue);
    }

    public void selectYear(String yearValue) {
        Select selectYear = new Select(yearsDropdown);
        selectYear.selectByVisibleText(yearValue);
    }

    public void clickNewsletter() {
        newsletterCheckbox.click();
    }

    public void clickSpecialOffers() {
        optinCheckbox.click();
    }

    public void enterFirstName(String fName) {
        firstNameInput.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastNameInput.sendKeys(lName);
    }

    public void enterCompany(String companyName) {
        companyInput.sendKeys(companyName);
    }

    public void enterAddress1(String addr1) {
        address1Input.sendKeys(addr1);
    }

    public void enterAddress2(String addr2) {
        address2Input.sendKeys(addr2);
    }

    public void selectCountry(String countryName) {
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(countryName);
    }

    public void enterState(String stateName) {
        stateInput.sendKeys(stateName);
    }

    public void enterCity(String cityName) {
        cityInput.sendKeys(cityName);
    }

    public void enterZipcode(String zip) {
        zipcodeInput.sendKeys(zip);
    }

    public void enterMobileNumber(String mobile) {
        mobileInput.sendKeys(mobile);
    }

    public void clickCreateAccountButton() {
        createAccountBtn.click();
    }
    public void clickContinueButton() {
        continuebtn.click();
    }

}
