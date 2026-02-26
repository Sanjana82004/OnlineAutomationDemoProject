package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericsUtils;

public class basePage {

	public WebDriver driver;
	public GenericsUtils utils;
    public basePage(WebDriver driver) {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    	utils = new GenericsUtils(driver);
    	}
}
