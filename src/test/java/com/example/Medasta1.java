package com.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;

import java.net.MalformedURLException;
import java.net.URL;

public class Medasta1 {

    private AppiumDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "9eee7c3");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);

        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test(priority = 1)
    public void negetive() throws InterruptedException {
        // Click on WhatsApp
        WebElement Wclick = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"WhatsApp\"]"));
        Wclick.click();

        // Click search bar and search for "Medasta ECPL"
        driver.findElement(AppiumBy.id("com.whatsapp:id/search_text")).click();
        WebElement searchbar = driver.findElement(AppiumBy.className("android.widget.EditText"));
        searchbar.sendKeys("Medasta ECPL");

        // Click on the conversation
        driver.findElement(By.id("com.whatsapp:id/conversations_row_content")).click();
        Thread.sleep(500); // Short delay for conversation to load

        // Send initial message
        WebElement input = driver.findElement(By.id("com.whatsapp:id/entry"));
        input.sendKeys("Syring"); // Assuming this triggers a bot reply with product details
        driver.findElement(By.id("com.whatsapp:id/send")).click();
        Thread.sleep(33500); 
        // Wait for the product message to appear (e.g., bot reply)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'ESTELITE Alpha syringe kit')]")
        ));
        System.out.println("Product message 'ESTELITE Alpha syringe kit' appeared successfully.");

        // Scroll to the first product: "ESTELITE Alpha syringe kit"
        String scrollToProduct1 = "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10).scrollIntoView(" +
                                 "new UiSelector().textContains(\"ESTELITE Alpha syringe kit\"))";
        try {
            driver.findElement(AppiumBy.androidUIAutomator(scrollToProduct1));
            System.out.println("Scrolled to 'ESTELITE Alpha syringe kit' successfully.");
        } catch (Exception e) {
            System.err.println("Failed to scroll to 'ESTELITE Alpha syringe kit': " + e.getMessage());
            throw e;
        }

        // Wait for the product container to be present
        WebElement productContainer1 = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'ESTELITE Alpha syringe kit') and contains(@text, '3.3GM X 4 (A2 X2, UA2X1)') and contains(following-sibling::android.widget.TextView/@text, '2:15 pm')]/ancestor::android.view.ViewGroup")
        ));

        // Find and tap the "list - 1" button using W3C actions
        WebElement listButton1 = wait.until(ExpectedConditions.visibilityOf(
            productContainer1.findElement(AppiumBy.xpath(".//android.widget.TextView[@text='list - 1']"))
        ));
        if (listButton1.isDisplayed() && listButton1.isEnabled()) {
            System.out.println("Found and verified 'list - 1' button for 'ESTELITE Alpha syringe kit'.");
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.fromElement(listButton1), 0, 0))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(50)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            ((AppiumDriver) driver).perform(Collections.singletonList(tap));
            System.out.println("Tapped 'list - 1' button for 'ESTELITE Alpha syringe kit' successfully.");
        } else {
            System.err.println("Button for 'ESTELITE Alpha syringe kit' not tappable: displayed=" + listButton1.isDisplayed() + ", enabled=" + listButton1.isEnabled());
            throw new RuntimeException("Button not tappable.");
        }

        // Scroll to the second product: "Palfique Universal Flow Medium L Syringe"
        String scrollToProduct2 = "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10).scrollIntoView(" +
                                 "new UiSelector().textContains(\"Palfique Universal Flow Medium L Syringe\"))";
        try {
            driver.findElement(AppiumBy.androidUIAutomator(scrollToProduct2));
            System.out.println("Scrolled to 'Palfique Universal Flow Medium L Syringe' successfully.");
        } catch (Exception e) {
            System.err.println("Failed to scroll to 'Palfique Universal Flow Medium L Syringe': " + e.getMessage());
            throw e;
        }

        // Wait for the second product container to be present
        WebElement productContainer2 = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Palfique Universal Flow Medium L Syringe')]/ancestor::android.view.ViewGroup")
        ));

        // Find and tap the "list - 1" button for the second product
        WebElement listButton2 = wait.until(ExpectedConditions.visibilityOf(
            productContainer2.findElement(AppiumBy.xpath(".//android.widget.TextView[@text='list - 1']"))
        ));
        if (listButton2.isDisplayed() && listButton2.isEnabled()) {
            System.out.println("Found and verified 'list - 1' button for 'Palfique Universal Flow Medium L Syringe'.");
            PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.fromElement(listButton2), 0, 0))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(50)))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            ((AppiumDriver) driver).perform(Collections.singletonList(tap2));
            System.out.println("Tapped 'list - 1' button for 'Palfique Universal Flow Medium L Syringe' successfully.");
        } else {
            System.err.println("Button for 'Palfique Universal Flow Medium L Syringe' not tappable: displayed=" + listButton2.isDisplayed() + ", enabled=" + listButton2.isEnabled());
            throw new RuntimeException("Button not tappable.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}