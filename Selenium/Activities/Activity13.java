package javaSeleniumexamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity13 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/tables");
		
		//Get the title of the page and print it to the console
		System.out.println("Page title is: "+driver.getTitle());

		/*
		 * Using xpaths on the table: 
		 * Find the number of rows and columns in the table
		 * and print them. Find and print all the cell values in the third row of the
		 * table. Find and print the cell value at the second row second column.
		 */
		
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		
		System.out.println("Number of rows: "+rows.size());
		System.out.println("Number of columns: "+columns.size());
		
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		System.out.println("All Cell values in 3rd row: ");
		for(WebElement element:thirdRow) {
			System.out.print(element.getText()+" ");
		}
		
		System.out.println("Second row 2nd column value is: "+driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
		
		//Close the browser
		driver.close();

	}

}
