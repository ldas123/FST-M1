package seleniumproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class SuiteCRM {
	
	static WebDriver driver;
	static WebDriverWait wait;
	JavascriptExecutor js;
	
	@BeforeMethod
	public void invokeBrowser() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://crm.alchemy.hguy.co");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js = (JavascriptExecutor)driver;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void activity1() {
		wait.until(ExpectedConditions.titleIs("SuiteCRM"));
		Assert.assertEquals(driver.getTitle(), "SuiteCRM");
	}
	
	@Test
	public void activity2() {
		//Locate the header logo image
		WebElement headerImage = driver.findElement(By.className("image-company_logo"));
		
		//Extract the src attribute(this gives the url)
		String imageUrl = headerImage.getAttribute("src");
		
		//Print the url to the console
		System.out.println("Header Image url: "+imageUrl);
	}
	
	@Test
	public void activity3() {
		//Get the first copyright text in the footer
		String firstCopyrightText = driver.findElement(By.xpath("//div[@class='copyright-links']/a[1]")).getText();
		System.out.println("First Copyright text is: "+firstCopyrightText);
	}
	
	@Test
	public void activity4() {
		//Find and select the username and password fields
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].click();", loginBtn);
		
		WebElement accountsBtn = driver.findElement(By.xpath("//span[text()='Accounts']"));
		wait.until(ExpectedConditions.visibilityOf(accountsBtn));
	}
	
	@Test
	public void activity5() {
		//Find and select the username and password fields
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].click();", loginBtn);
		WebElement accountsBtn = driver.findElement(By.xpath("//span[text()='Accounts']"));
		wait.until(ExpectedConditions.visibilityOf(accountsBtn));
		
		//Get the color of the navigation menu and print it to the console
		WebElement navLink = driver.findElement(By.className("home-nav-link"));
		
		//Get the backgroung color
		String backgroundColor = navLink.getCssValue("background-color");
		System.out.println("Navigation menu Color (RGBA): "+backgroundColor);
		
	}
	
	@Test
	public void activity6() {
		//Find and select the username and password fields
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].click();", loginBtn);
		
		//Make sure that the “Documents” menu item exists and is clickable
		WebElement docLink = driver.findElement(By.xpath("//span[text()='Documents']"));
		wait.until(ExpectedConditions.visibilityOf(docLink));
		Assert.assertTrue(docLink.isEnabled());
	}
	
	@Test
	public void activity7() throws InterruptedException {
		//Find and select the username and password fields
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].click();", loginBtn);
		
		//Make sure that the “Documents” menu item exists and is clickable
		WebElement leadsLink = driver.findElement(By.xpath("//span[text()='Leads']"));
		wait.until(ExpectedConditions.visibilityOf(leadsLink));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement freshleadsLink = driver.findElement(By.xpath("//span[text()='Leads']"));
		action.moveToElement(freshleadsLink).perform();
		WebElement viewLeads = driver.findElement(By.xpath("//span[text()='View Leads']"));
		wait.until(ExpectedConditions.elementToBeClickable(viewLeads));
		
		viewLeads.click();
		
		String leadName = driver.findElement(By.xpath("//table/tbody/tr/td[3]//scrm-varchar-detail")).getText();
		System.out.println("Lead Name is: "+leadName);
		
	}
	
	@Test
	public void activity8() {
		//Find and select the username and password fields
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].click();", loginBtn);
		
		//Open the accounts page and print the contents of the table
		WebElement accountsLink = driver.findElement(By.xpath("//span[text()='Accounts']"));
		wait.until(ExpectedConditions.visibilityOf(accountsLink));
		WebElement freshaccountsLink = driver.findElement(By.xpath("//span[text()='Accounts']"));
		Actions action = new Actions(driver);
		action.moveToElement(freshaccountsLink).perform();
		WebElement viewAccounts = driver.findElement(By.xpath("//span[text()='View Accounts']"));
		wait.until(ExpectedConditions.elementToBeClickable(viewAccounts));
		viewAccounts.click();
		
		System.out.println("Names of all Odd columns: ");
		List<WebElement> namesList = driver.findElements(By.xpath("//table/tbody/tr/td[3]//scrm-varchar-detail"));
		for(WebElement name:namesList) {
			System.out.println(name.getText());
		}
	}
	
	@Test
	public void activity9() throws InterruptedException {
		//Find and select the username and password fields
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("5Nx#I6BK%r3$8vz0ch");
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].click();", loginBtn);
		
		//Open the leads page and print the usernames and full names from the table
		Thread.sleep(5000);
//		WebElement leadsLink = driver.findElement(By.xpath("//span[text()='Leads']"));
//		wait.until(ExpectedConditions.visibilityOf(leadsLink));
		Actions action = new Actions(driver);
		WebElement freshleadsLink = driver.findElement(By.xpath("//span[text()='Leads']"));
		action.moveToElement(freshleadsLink).perform();
		WebElement viewLeads = driver.findElement(By.xpath("//span[text()='View Leads']"));
		wait.until(ExpectedConditions.elementToBeClickable(viewLeads));
		
		viewLeads.click();
		
		System.out.println("Names of all Odd columns: ");
		List<WebElement> namesList = driver.findElements(By.xpath("//table/tbody/tr/td[3]//scrm-varchar-detail"));
		for(WebElement name:namesList) {
			System.out.println(name.getText());
		}
		
		System.out.println("usernames list: ");
		List<WebElement> userNamesList = driver.findElements(By.xpath("//table/tbody/tr/td[8]//scrm-relate-detail"));
		for(WebElement uname:userNamesList) {
			System.out.println(uname.getText());
		}
		
	}

}
