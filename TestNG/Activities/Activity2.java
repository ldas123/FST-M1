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

public class Activity2 {
	
	static WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test
	public void getTitle() {
		String titleActual = driver.getTitle() ;
		String titleExpected = "Selenium: Target Practice";
		System.out.println("Title is: "+titleActual);
		Assert.assertEquals(titleActual, titleExpected);
	}
	
	@Test
	public void secondTest() {
		WebElement blackBtn = driver.findElement(By.xpath("//button[text()='Black']"));
		Assert.assertTrue(blackBtn.isDisplayed());
		Assert.assertEquals(blackBtn.getText(), "Black");
	}
	
	@Test(enabled=false)
	public void thirdTest() {
		
	}
	
	@Test
	public void fourthTest() throws SkipException{
		throw new SkipException("Skipping Deliberately");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
