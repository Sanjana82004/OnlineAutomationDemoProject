package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericsUtils {
   
	WebDriver driver;

    public GenericsUtils(WebDriver driver) {
        this.driver = driver;
    }
    
    public void jsClick(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("JS Click failed: " + e.getMessage());
        }
    }
    
    
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Element ko screen ke top par scroll karega
        js.executeScript("arguments[0].scrollIntoView(true);", element); 
    }
    // Common method for Explicit Wait
    public WebElement waitForElementVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitForElementClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
}
