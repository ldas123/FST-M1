package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
	static WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
	@Test
	public void testMethod() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(3000);
		String actualText = driver.findElement(By.xpath("//h2[text()='Welcome Back, Admin!']")).getText();
		Assert.assertEquals(actualText, "Welcome Back, Admin!");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
