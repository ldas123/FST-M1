package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	
	// Declaring the common objects
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Set the desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		// Use the app package and appActivity to open apps
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		
		/* For IOS
		 * options.setCapability("bundleId", "com.apple.AppName");
		 */
		
		// option to provide app reset
		options.noReset();
		
		// Set the appium server
		URL serverUrl = new URI("http://localhost:4723").toURL();
		
		// Initialize the object
		driver = new AndroidDriver(serverUrl,options);
		
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void testMethod() {
		// To open a page
		driver.get("https://training-support.net");
		
		// Locate and tap About Us link
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).click();
		// Verify the redirect to About Us page
		String headerText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
		assertEquals(headerText,"About Us");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
