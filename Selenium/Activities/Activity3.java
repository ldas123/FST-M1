package javaSeleniumexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		//Instantiate ChromeDriver
				WebDriver driver = new ChromeDriver();
				
				//Navigating to the page
				driver.get("https://training-support.net/webelements/login-form/");
				
				//Get the title of the page and print it to the console
				System.out.println("Title of page is: "+driver.getTitle());
				
				Thread.sleep(Duration.ofSeconds(3));
				
				//Find the username field using any locator and enter "admin" into it
				driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
				
				//Find the password field using any locator and enter "password" into it
				driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");
				
				//Find the "Log in" button using any locator and click it.
				driver.findElement(By.xpath("//button[text()='Submit']")).click();
				
				//Close the browser
				driver.close();

	}

}
