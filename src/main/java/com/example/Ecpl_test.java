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

public class Ecpl_test {
  WebDriver driver;

  @BeforeClass
  public void setup() {
      // WebDriverManager will download and set up the correct ChromeDriver
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
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


