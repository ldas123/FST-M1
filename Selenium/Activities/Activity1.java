package javaSeleniumexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {

	public static void main(String[] args) throws InterruptedException {
		
		//Instantiate ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		//Navigating to the page
		driver.get("https://training-support.net");
		
		//Getting the title of the page
		System.out.println("Title of page is: "+driver.getTitle());
		
		Thread.sleep(Duration.ofSeconds(3));
		
		//Click the about us button
		driver.findElement(By.xpath("//*[text()='About Us']")).click();
		
		//Print the title of the new page
		System.out.println("Title of page is: "+driver.getTitle());
		
		//Closing the page
		driver.close();;

	}

}
