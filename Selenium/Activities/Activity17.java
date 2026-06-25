package javaSeleniumexamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/selects");
		
		//Get the title of the page and print it to the console
		System.out.println("title of the page: "+driver.getTitle());
		
		
		WebElement selectOptions = driver.findElement(By.xpath("(//select)[last()]"));
		Select select = new Select(selectOptions);
		
		//Select the "HTML" option using the visible text
		select.selectByVisibleText("HTML");
		
		//Select the 4th, 5th and 6th options using the index
		select.selectByIndex(3);
		select.selectByIndex(4);
		select.selectByIndex(5);
		
		//elect the "Node" option using the value
		select.selectByValue("nodejs");
		
		//Deselect the 5th option using index
		select.deselectByIndex(4);
		
		driver.close();

	}

}
