package javaSeleniumexamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity20 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/alerts");
		
		System.out.println("Title of the page is: "+driver.getTitle());
		
		//Find the button to open a PROMPT alert and click it
		driver.findElement(By.id("prompt")).click();
		
		//Switch the focus from the main window to the Alert box and get the text in it and print it.
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text is: "+alert.getText());
		
		//Type "Awesome!" into the prompt
		alert.sendKeys("Awesome!");

		//Close the alert by clicking Ok
		alert.accept();
		
		//Close the browser
		driver.close();

	}

}
