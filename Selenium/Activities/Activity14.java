package javaSeleniumexamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity14 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/tables");
		
		//Get the title of the page and print it to the console
		System.out.println("Page title is: "+driver.getTitle());

		//Find the number of rows and columns in the table and print them
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		
		System.out.println("Number of rows: "+rows.size());
		System.out.println("Number of columns: "+columns.size());
		
		//Find and print the Book Name in the 5th row
		System.out.println("Book Name in the 5th row is: "+driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
		
		//Click the header of the Price column to sort it in ascending order
		driver.findElement(By.xpath("//th[text()='Price']")).click();
		
		//Find and print the Book Name in the 5th row again
		System.out.println("Book Name in the 5th row is: "+driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
		
		//Close the browser
		driver.close();

	}

}
