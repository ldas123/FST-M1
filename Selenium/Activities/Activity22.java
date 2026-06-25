package javaSeleniumexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/popups");

		// Print the title of the page
		System.out.println("Title of the page is: " + driver.getTitle());

		// Find the button on the page and click it to launch the popup
		driver.findElement(By.id("launcher")).click();

		/*
		 * Wait for the popup to appear and then enter the credentials: 
		 * username: admin
		 * password: password
		 */
		
		WebElement username = driver.findElement(By.id("username"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(username));
		
		username.sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		
		//Click submit and print the message on the page after logging in
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		WebElement successMsg = driver.findElement(By.xpath("//span[@class='text-black']"));
		wait.until(ExpectedConditions.visibilityOf(username));
		
		System.out.println(successMsg.getText());
		
		driver.close();

	}

}
