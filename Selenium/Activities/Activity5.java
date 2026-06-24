package javaSeleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity5 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");

		// Get the title of the page and print it to the console
		System.out.println("Page Title is: " + driver.getTitle());
		
		//Find the checkbox input element
		WebElement checkBox = driver.findElement(By.id("checkbox"));
		
		//Check if it is visible on the page
		System.out.println("Checkbox is visible: "+checkBox.isDisplayed());
		
		//Click the "Remove Checkbox" button
		driver.findElement(By.xpath("//*[text()='Toggle Checkbox']")).click();
		
		//Check if it is visible again and print the result
		System.out.println("Checkbox is visible: "+checkBox.isDisplayed());
		
		//Close the browser
		driver.close();

	}

}
