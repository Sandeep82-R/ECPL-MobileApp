package com.example;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class MobileApp {

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
    public void clickButtonTest() throws InterruptedException, IOException {
//    	WebElement button = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Lenskart']"));
//    	button.click();
//    	System.out.println("Button clicked successfully!");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(68));
    	driver.findElement(AppiumBy.xpath("//*[contains(@text, 'WhatsApp')]")).click();
    	System.out.println("Whatsapp clicked successfully!");
//    	Thread.sleep(500);
//    	driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Swipe down to reveal additional actions\"]/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView")).sendKeys("Medasta");
    	driver.findElement(AppiumBy.id("com.whatsapp:id/search_text")).click();
//    	Thread.sleep(1000);
    	WebElement searchbar = driver.findElement(AppiumBy.className("android.widget.EditText"));
//    	Thread.sleep(500);
    	searchbar.sendKeys("Medasta ECPL");
    	Thread.sleep(1000);
    	driver.findElement(By.id("com.whatsapp:id/conversations_row_content")).click();
    	Thread.sleep(500);
   
    	
    	    	driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("Syringe");
    	    	System.out.println("1st Script");
    	Thread.sleep(1000);
    	driver.findElement(By.id("com.whatsapp:id/send")).click();
    	Thread.sleep(35000);
//    	Select Product
    	
    	driver.findElement(By.id("com.whatsapp:id/button_content")).click();


    		Thread.sleep(1000);
    		//Select the sub product
    	driver.findElement(By.className("android.widget.RadioButton")).click();
    	Thread.sleep(1000);
    	//select button
    	driver.findElement(By.id("com.whatsapp:id/select_list_button")).click();
    	Thread.sleep(4000);
    	WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text, 'Confirm Cart Items')]")));
    	cart.click();
    	WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text, 'Provide address')]")));
    	address.click();
    	
    	WebElement element = driver.findElement(
    		    AppiumBy.androidUIAutomator(
    		        "new UiSelector().className(\"android.widget.RadioButton\").index(0)"
    		    )
    		);

    		// Perform action
    		element.click();
    	
    	
    	
    	
    	
    	
    	
    	
//    	//conform cart
//    	driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Confirm Cart Items\"]/android.widget.TextView")).click();
//    	Thread.sleep(5000);
//    	//Select Address
//    	driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Provide address\"]/android.widget.TextView")).click();
//    	Thread.sleep(1000);
//    	//Choose address
//    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RadioGroup/android.widget.RadioButton[1]")).click();
    	//Confirm Address
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[contains(@text, 'CONFIRM')]")).click();
    	Thread.sleep(5000);
    	//Checkout
    	WebElement checkOut1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@content-desc=\"Checkout\"]/android.widget.TextView")));
    	checkOut1.click();
    	WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text, 'MEDASTA')]")));
    	title.getText();
    	
    			// Scroll until the "PLACE ORDER" element is visible
    			driver.findElement(AppiumBy.androidUIAutomator(
    			    "new UiScrollable(new UiSelector().scrollable(true))" +
    			    ".scrollIntoView(new UiSelector().text(\"PLACE ORDER\"));"
    			));

    			Thread.sleep(1000);
    	
    	//Place order
//    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView")).click();
    	
    	WebElement placeOrderButton = driver.findElement(AppiumBy.xpath("//*[contains(@text, 'PLACE ORDER')]"));
    	placeOrderButton.click();
    	System.out.println("Place Order Button clicked!");
    			
    			
    			
    			
    			
    	
    	
    	//Back to Whatsapp
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.TextView")).click();
    	Thread.sleep(3000);
    	//Clear Chat Data 
    	//vertical elipes
    	driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
//    	More
    	Thread.sleep(1000);
    	WebElement moreopt = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"More button\"]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
    	moreopt.click();
    	
    	//clear chat
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).click();
    	//Clear button
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")).click();
    	
    }
    
    
 
    public void negetive() throws InterruptedException {
   
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//    	WebElement Wclick = driver.findElement(AppiumBy.xpath("//*[contains(@text, 'WhatsApp')]"));
//    	Wclick.click();
//    	driver.findElement(AppiumBy.id("com.whatsapp:id/search_text")).click();
//
//    	WebElement searchbar = driver.findElement(AppiumBy.className("android.widget.EditText"));
//
//    	searchbar.sendKeys("Medasta ECPL");
//
//    	driver.findElement(By.id("com.whatsapp:id/conversations_row_content")).click();
//    	Thread.sleep(500);
    	WebElement input = driver.findElement(By.id("com.whatsapp:id/entry"));
////    	input.sendKeys("Negetive");
////    	driver.findElement(By.id("com.whatsapp:id/send")).click();
//    	
////    	input.sendKeys("ESTELITE Alpha syringe kit");
//    	
    	input.sendKeys("Syringe ");
    	driver.findElement(By.id("com.whatsapp:id/send")).click();
    	
    	Thread.sleep(30000);

    	
//    	// Find the product container by its name
//    	WebElement productContainer = driver.findElement(AppiumBy.xpath(
//    	    "//android.widget.TextView[@text='ESTELITE Alpha syringe kit']/ancestor::android.view.ViewGroup"
//    	));
//    	Thread.sleep(1000);
//    	// Now find the list-1 button inside this container
//    	WebElement listButton = productContainer.findElement(AppiumBy.xpath(
//    	    ".//android.widget.TextView[@text='list - 1']"
//    	));
//
//    	// Click the button
//    	listButton.click();
//    	System.out.println("✅ Clicked the correct list-1 button for ESTELITE Alpha syringe kit");

//    	=-=-=-=-=-=-=-
    	// Scroll and click method
    	
    	
    	
  	
    	
    	
//    	
    	// Scroll to the specific product
    	String scrollToProduct = "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10).scrollIntoView(" +
    	                        "new UiSelector().textContains(\"Palfique Universal Flow Medium L Syringe\"))";
    	try {
    	    driver.findElement(AppiumBy.androidUIAutomator(scrollToProduct));
    	    System.out.println("Scrolled to 'Palfique Universal Flow Medium L Syringe' successfully.");

    	    // Additional scroll to ensure the "Shades" message is visible
    	    String scrollToShades = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
    	                           "new UiSelector().text(\"Shades\"))";
    	    
    	    driver.findElement(AppiumBy.androidUIAutomator(scrollToShades));
    	    System.out.println("Scrolled to 'Shades' message successfully.");
    	} catch (Exception e) {
    	    System.err.println("Failed to scroll to product or Shades: " + e.getMessage());
    	    throw e; // Fail the test if scrolling fails
    	}

    	// Wait for the product details container to be present
//    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement productContainer = wait.until(ExpectedConditions.presenceOfElementLocated(
    	    AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Palfique Universal Flow Medium L Syringe')]/ancestor::android.view.ViewGroup")
    	));

    	// Find the message container with "Shades" and the "list - 1" button
    	WebElement shadesContainer = null; // Declare outside try block
    	try {
    	    shadesContainer = wait.until(ExpectedConditions.presenceOfElementLocated(
    	        AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Palfique Universal Flow Medium L Syringe')]/ancestor::android.view.ViewGroup/following-sibling::android.view.ViewGroup[//android.widget.TextView[contains(@text, 'Shades')]]")
    	    ));
    	    WebElement listButton = wait.until(ExpectedConditions.elementToBeClickable(
    	        shadesContainer.findElement(AppiumBy.xpath(".//android.widget.TextView[@text='list - 1']"))
    	    ));
    	    System.out.println("Found 'list - 1' button in 'Shades' message.");
    	    listButton.click();
    	    System.out.println("Clicked 'list - 1' button successfully.");
    	} catch (Exception e) {
    	    System.err.println("Failed to click 'list - 1' button: " + e.getMessage());
    	    if (shadesContainer != null) {
    	        // Fallback: Try clicking using JavaScript
    	        JavascriptExecutor js = (JavascriptExecutor) driver;
    	        js.executeScript("arguments[0].click();", shadesContainer.findElement(AppiumBy.xpath(".//android.widget.TextView[@text='list - 1']")));
    	        System.out.println("Clicked 'list - 1' button using JavaScript as fallback.");
    	    } else {
    	        System.err.println("shadesContainer is null, cannot proceed with fallback.");
    	        // Fallback: Scroll and retry
    	        try {
    	        	String scrollToShades = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                            "new UiSelector().text(\"Shades\"))";
    	            driver.findElement(AppiumBy.androidUIAutomator(scrollToShades));
    	            shadesContainer = wait.until(ExpectedConditions.presenceOfElementLocated(
    	                AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Shades')]/ancestor::android.view.ViewGroup")
    	            ));
    	            WebElement listButton = wait.until(ExpectedConditions.elementToBeClickable(
    	                shadesContainer.findElement(AppiumBy.xpath(".//android.widget.TextView[@text='list - 1']"))
    	            ));
    	            listButton.click();
    	            System.out.println("Clicked 'list - 1' button after retry.");
    	        } catch (Exception ex) {
    	            System.err.println("Failed to retry clicking 'list - 1' button: " + ex.getMessage());
    	            throw ex; // Fail the test if all retries fail
    	        }
    	    }
    	}

   	
    	Thread.sleep(500);
    	driver.findElement(By.xpath("//*[contains(@text, 'A3.5')]")).click();
    	
    	driver.findElement(By.id("com.whatsapp:id/select_list_button")).click();
//    	Thread.sleep(1500);
//    	driver.findElement(By.xpath("//*[contains(@text, 'Confirm Cart Items')]")).click();
    	WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text, 'Confirm Cart Items')]")));
    	cart.click();
    	WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text, 'Provide address')]")));
    	address.click();
    	
    	
//    	Thread.sleep(1500);
//    	driver.findElement(By.xpath("//*[contains(@text, 'Provide address')]")).click();
    	Thread.sleep(1500);
    	driver.findElement(By.id("com.whatsapp:id/add_shipping_address")).click();
    	Thread.sleep(500);
    	driver.findElement(By.xpath("//*[contains(@text, 'Name')]")).sendKeys("Sandeep");
    	Thread.sleep(500);
    	driver.findElement(By.xpath("//*[contains(@text, 'Phone')]")).sendKeys("1234567890");
    	Thread.sleep(500);
    	driver.findElement(By.xpath("//*[contains(@text, 'Pin Code')]")).sendKeys("560043");
    	Thread.sleep(500);
    	driver.findElement(By.xpath("//*[contains(@text, 'Address Line')]")).sendKeys("Kalyan Nagar HRBR 2nd block Bengaluru");

    	driver.findElement(By.xpath("//*[contains(@text, 'Floor Number (Optional)')]")).sendKeys("2nd Floor");
    	driver.findElement(By.xpath("//*[contains(@text, 'Tower Number (Optional)')]")).sendKeys("4th Tower");	
    	driver.findElement(By.xpath("//*[contains(@text, 'Landmark Area')]")).sendKeys("Om Shakthi temple");	
  
    	WebElement cityField = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"City\"))"));
    	cityField.sendKeys("Benagluru");
    	WebElement stateField = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"State\"))"));
    	stateField.sendKeys("Karnataka");
    	Thread.sleep(500);
    	driver.findElement(By.xpath("//*[contains(@text, 'SEND ADDRESS')]")).click();
    	Thread.sleep(500);
    	
    	
    	
    	WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@content-desc=\"Checkout\"]/android.widget.TextView")));
    	checkOut.click();
    	
    	Thread.sleep(5000);
    	
    	
    	WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text, 'MEDASTA')]")));
    	title.click();
    	
//    	Increase the Quantity
    	driver.findElement(By.className("android.widget.EditText")).sendKeys("5");
    	Thread.sleep(1000);
    			// Scroll until the "PLACE ORDER" element is visible
    			driver.findElement(AppiumBy.androidUIAutomator(
    			    "new UiScrollable(new UiSelector().scrollable(true))" +
    			    ".scrollIntoView(new UiSelector().text(\"PLACE ORDER\"));"
    			));

    			Thread.sleep(1000);
    			WebElement placeOrderButton = driver.findElement(AppiumBy.xpath("//*[contains(@text, 'PLACE ORDER')]"));
    	    	placeOrderButton.click();
    	    	System.out.println("Place Order Button clicked!");
    			
    		   
    		
    		
    				
    	
    	Thread.sleep(5000);
    	driver.quit(); // Ends the current session cleanly 
    }
    
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
