package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeClass
	public void invokeBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://training-support.net");
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	@Test
	public void getTitle() {
		String titleActual = driver.getTitle() ;
		String titleExpected = "Training Support";
		System.out.println("Title is: "+titleActual);
		Assert.assertEquals(titleActual, titleExpected);
		
		WebElement aboutUsBtn = driver.findElement(By.linkText("About Us"));
		aboutUsBtn.click();
		
		WebElement element = driver.findElement(By.xpath("//h1[text()='About Us']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		String newTitle = "About Training Support";
		String newTitleActual = driver.getTitle();
		
		System.out.println("New Title is: "+newTitleActual);
		Assert.assertEquals(newTitleActual, newTitle);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
