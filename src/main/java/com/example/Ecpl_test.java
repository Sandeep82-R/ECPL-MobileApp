package com.example;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ecpl_test {
	WebDriver driver;
    WebDriverWait wait;
  @BeforeClass
  public void setup() {
	  WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
      // Specify a unique user data directory
      String tempDir = System.getProperty("java.io.tmpdir") + "/chrome_profile_" + System.currentTimeMillis();
      options.addArguments("--user-data-dir=" + tempDir);
      driver = new ChromeDriver(options);
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Test
  public void loginTest() throws InterruptedException, IOException {
    
      driver.get("https://www.amazon.in/");

      driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Testing 12333");
      Thread.sleep(2500);
      driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).clear();
      Thread.sleep(2000);
      driver.quit();
   

  }

  @AfterClass
  public void tearDown() {
      if (driver != null) {
          driver.quit();
      }
  }
  
}


