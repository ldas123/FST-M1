package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends BaseClass {
	
	static Alert alert;
	
	@Given("User is on the page")
	public static void user_on_page() {
		driver.get("https://training-support.net/webelements/alerts");
		Assertions.assertEquals(driver.getTitle(), "Selenium: Alerts");
	}
	
	@When("clicks the Simple Alert button")
	public static void click_simple_alert_btn() {
		driver.findElement(By.id("simple")).click();
	}
	
	@Then("Alert opens")
	public static void switch_to_alert() {
		alert = driver.switchTo().alert();
	}
	
	@And("Read the text from it and print it")
	public static void read_alert_text() {
		System.out.println("Alert text is: "+alert.getText());
	}
	
	@And("Close the alert")
	public static void close_alert() {
		alert.accept();
	}
	
	@And("Read the result text")
	public static void read_alert_result() {
		String alertText = driver.findElement(By.id("result")).getText();
		System.out.println("Alert result text is: "+alertText);
	}
	
	@When("User clicks the Confirm Alert button")
	public static void click_confirm_alert_btn() {
		driver.findElement(By.id("confirmation")).click();
	}
	
	@And("Close the alert with Cancel")
	public static void cancle_alert() {
		alert.dismiss();
	}
	
	@When("User clicks the Prompt Alert button")
	public static void click_prompt_alert_btn() {
		driver.findElement(By.id("prompt")).click();
	}
	
	@And("Write a custom message in it")
	public static void write_custom_msg() {
		alert.sendKeys("This is prompt alert");
	}

}
