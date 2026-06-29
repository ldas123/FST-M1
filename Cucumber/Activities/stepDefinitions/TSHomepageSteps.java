package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TSHomepageSteps extends BaseClass{
	
	@Given("user is on the TS homepage")
	public void open_ts_homepage() {
		// Open the browser
		driver.get("https://training-support.net");
		Assertions.assertEquals(driver.getTitle(),"Training Support");
	}
	
	@When("the user clicks on the About Us link")
	public void click() {
		driver.findElement(By.linkText("About Us")).click();
	}
	
	@Then("they are redirected to another page")
	public void verify_page() {
		wait.until(ExpectedConditions.titleIs("About Training Support"));
		String pageHeading = driver.findElement(By.cssSelector("h1.text-center")).getText();
		 
		System.out.println("New page title is: " + pageHeading);
		Assertions.assertEquals(pageHeading, "About Us");
	}

}
