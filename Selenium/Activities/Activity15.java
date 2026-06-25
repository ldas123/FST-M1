package javaSeleniumexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/dynamic-attributes");
		
		//Get the title of the page and print it to the console
		System.out.println("Page title is: "+driver.getTitle());
		
		//Find the input fields and type in the required data in the fields
		driver.findElement(By.xpath("//input[starts-with(@name,'full-name-')]")).sendKeys("Laxmi");
		driver.findElement(By.xpath("//input[contains(@name,'-email')]")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("22-04-2000");
		driver.findElement(By.xpath("//*[contains(@id,'-additional-details-')]")).sendKeys("All Good");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		WebElement confirmation = driver.findElement(By.id("action-confirmation"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(confirmation));
		
		System.out.println(confirmation.getText());
		
		driver.close();

	}

}
