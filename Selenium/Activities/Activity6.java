package javaSeleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity6 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");

		// Get the title of the page and print it to the console
		System.out.println("Page Title is: " + driver.getTitle());
		
		//Find the checkbox input element
		WebElement checkBox = driver.findElement(By.id("checkbox"));
		
		//Check if the checkbox is selected and print the result
		System.out.println("Checkbox is selected: "+checkBox.isSelected());
		
		//Click the checkbox to select it
		checkBox.click();
		
		//Check if the checkbox is selected again and print the result
		System.out.println("Checkbox is selected: "+checkBox.isSelected());
		
		//Close the browser
		driver.close();

	}

}
