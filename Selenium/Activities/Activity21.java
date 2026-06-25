package javaSeleniumexamples;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity21 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://training-support.net/webelements/tabs");
		
		System.out.println("Page title is: "+driver.getTitle());
		
		String parent = driver.getWindowHandle();
		
		//Find the button to open a new tab and click it
		driver.findElement(By.xpath("//button[text()='Open A New Tab']")).click();
		
		//Wait for the new tab to open. Once it opens, print all the handles
		Thread.sleep(2000);
		
		System.out.println("All window handles: "+driver.getWindowHandles());
		
		Set<String> allWindows = driver.getWindowHandles();
		
		//Switch to the newly opened tab, print the new tab's title and message
		for(String window: allWindows) {
			if(parent!=window) {
				driver.switchTo().window(window);
				System.out.println("new tab's title is: "+driver.getTitle());
			}
		}
		
		List<WebElement> texts = driver.findElements(By.xpath("//h1/span"));
		for(WebElement text:texts) {
			System.out.println(text.getText());
		}
		//Repeat the steps by clicking the button in the new tab page
		driver.findElement(By.xpath("//button[text()='Open Another One']")).click();
		
		//Close the browser
		driver.quit();

	}

}
