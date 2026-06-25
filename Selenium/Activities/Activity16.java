package javaSeleniumexamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/selects");
		
		//Get the title of the page and print it to the console
		System.out.println("title of the page: "+driver.getTitle());
		
		
		WebElement selectOptions = driver.findElement(By.xpath("(//select)[1]"));
		Select select = new Select(selectOptions);
		
		//Select the second option using the visible text
		select.selectByVisibleText("Two");
		
		//Select the third option using the index
		select.selectByIndex(3);
		
		//Select the fourth option using the value
		select.selectByValue("four");
		
		//Get all the options and print them to the console
		System.out.println("All Options: ");
		List<WebElement> options = select.getOptions();
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
		
		driver.close();

	}

}
