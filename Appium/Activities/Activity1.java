package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	
	// Declaring the common objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// File object for the application
		File testApp = new File("src/test/resources/Calculator.apk");
		// Set the desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		options.noReset();
		
		// Set the appium server
		URL serverUrl = new URI("http://localhost:4723").toURL();
		
		// Initialize the object
		driver = new AndroidDriver(serverUrl,options);
	}
	
	@Test
	public void testMethod() {
		driver.findElement(AppiumBy.accessibilityId("7")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();;
		driver.findElement(AppiumBy.accessibilityId("3")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = 
				driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		Assert.assertEquals(result, "10");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
