package project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumProjectNativeApp extends ActionsBase{

	// Declaring the common object
	AppiumDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// File object for the application
		File testApp = new File("src/test/resources/ToDO.apk");
		// Set the desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andriod");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		options.noReset();

		// Set appium server
		URL serverUrl = new URI("http://localhost:4723").toURL();

		// Initialize the object
		driver = new AndroidDriver(serverUrl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

//	@Test
	public void task1() throws InterruptedException {
		// Task 1
		String expectedText1 = "Complete Activity 1 with priority 1";
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListButtonNew")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription"))
				.sendKeys(expectedText1);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"7/22 – Wednesday\"]"))
				.click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
		
		String actualText1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Complete Activity 1 with priority 1\"]")).getText();
		Assert.assertEquals(actualText1, expectedText1);

		// Task 2
		String expectedText2 = "Complete Activity 2 with priority 2";
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListButtonNew")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription"))
				.sendKeys(expectedText2);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"7/22 – Wednesday\"]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
		
		
		String actualText2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Complete Activity 2 with priority 2\"]")).getText();
		Assert.assertEquals(actualText1, expectedText1);

		// Task 3
		String expectedText3 = "Complete Activity 3 with priority 3";
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/ListButtonNew")).click();
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailEditTextDescription"))
				.sendKeys(expectedText3);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonDueDate")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"7/23 – Thursday\"]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/DetailButtonOK")).click();
		
		String actualText3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Complete Activity 3 with priority 3\"]")).getText();
		Assert.assertEquals(actualText1, expectedText1);
	}
	
	@Test
	public void task2() throws InterruptedException {
		driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.xmission.trevin.android.todo:id/CategoryListButtonNew\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.xmission.trevin.android.todo:id/CategoryListItemID\"]")).sendKeys("New Category");
		driver.findElement(AppiumBy.id("com.xmission.trevin.android.todo:id/CategoryListButtonOK")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"All\"]")).click();
		
		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Complete Activity 2 with priority 2\"]"));
		doLongPress(driver,element);
		driver.findElement(AppiumBy.xpath("//android.widget.Spinner[@resource-id=\"com.xmission.trevin.android.todo:id/DetailSpinnerCategory\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"New Category\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.xmission.trevin.android.todo:id/DetailButtonOK\"]")).click();
	}
	
	public void task3() {
		driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoItemChecked\"])[1]")).click();;
		driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoItemChecked\"])[2]")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Toggle Show Completed\"]")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
