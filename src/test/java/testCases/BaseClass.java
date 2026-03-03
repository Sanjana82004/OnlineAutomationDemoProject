package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {

	    try {

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-popup-blocking");
	        options.addArguments("--disable-infobars");

	        driver = new ChromeDriver(options);
	        
	      logger = LogManager.getLogger(this.getClass());  

	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://automationexercise.com");

	    } catch (Exception e) {
	        System.out.println("Driver initialization failed: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
	@AfterClass
	
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException{
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())	;
    	
    	TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
    	File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\"+tname+"_"+timeStamp+".png";
    	File targetFile = new File(targetFilePath);
    	//FileUtils.copyFile(sourceFile, targetFile);
    	   sourceFile.renameTo(targetFile);
    	return targetFilePath;
    	}
	
	
	
}
