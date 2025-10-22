//package com.example;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class App {
//    public static void main(String[] args) {
//        // Setup ChromeDriver automatically
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        // Open a website
//        driver.get("https://www.google.com");
//
//        // Print page title
//        System.out.println("Title: " + driver.getTitle());
//
//        // Close browser
//        driver.quit();
//    }
//}

package com.example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class App {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // WebDriverManager will download and set up the correct ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "loginData", dataProviderClass = Data.class)
    public void loginTest(String username, String password) throws InterruptedException, IOException {
//        driver.get("https://www.google.com");
//        System.out.println("Title: " + driver.getTitle());
//        
//        
        driver.get("https://portal.spacebasic.com/login");

        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1500);
        
        takeScreenshot("login_" + username);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public void takeScreenshot(String filename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Save to your folder
        File dst = new File("/home/sandeep/Pictures/Automationimages/" + filename + ".png");

        // Create folder if missing
        dst.getParentFile().mkdirs();

        FileUtils.copyFile(src, dst);

        System.out.println("📸 Screenshot saved: " + dst.getAbsolutePath());
    }
    
    
}


