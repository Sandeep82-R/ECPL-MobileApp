package com.example;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "9eee7c3");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        AppiumDriver driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);

        WebElement button = driver.findElement(AppiumBy.id("com.example.app:id/button_id"));
        button.click();

        driver.quit();
    }
}


