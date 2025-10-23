package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void login(String username, String password) {
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://portal.spacebasic.com/login");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.id("loginButton")).click();

        // Optional: validate login result
        // String actualResult = driver.findElement(By.id("message")).getText();
        // Compare with expected

//        driver.quit();
    }  
}