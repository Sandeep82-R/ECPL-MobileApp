package com.example;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	   WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        // WebDriverManager will download and set up the correct ChromeDriver
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }
	    
	    @Test
	    public void TakeScreenShot() throws IOException, InterruptedException {
	    	driver.get("https://web.whatsapp.com/");
	    
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        By scannerLocator = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div[2]/div/div/canvas");
	        
	        // Wait until the scanner canvas is visible
	        wait.until(ExpectedConditions.visibilityOfElementLocated(scannerLocator));
	        
	        
	    	String saparateScreen = "Whatsapp2025";
	        TakesScreenshot ts = (TakesScreenshot)driver;
	       File src = ts.getScreenshotAs(OutputType.FILE);
	       File path = new File("/home/sandeep/Pictures/Fuction/" + saparateScreen+ ".png");
	       FileUtils.copyFile(src, path);
	      System.out.println("Screen Shot taken:" + path);
	    	
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
