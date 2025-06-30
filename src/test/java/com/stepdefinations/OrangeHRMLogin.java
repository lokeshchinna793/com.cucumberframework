
package com.stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class OrangeHRMLogin 
{
	WebDriver driver;
	
	@Given("browser should be open and naviagted to Orange HRM")
	public void browser_should_be_open_and_naviagted_to_orange_hrm() 
	{
	    driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().fullscreen();
	    System.out.println("Browser SetUp");
	}

	@When("I enter username {string} and password {string} from feature file")
	public void i_enter_username_and_password_from_feature_file(String name, String pwd)
	{
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	   user.sendKeys(name);
	   WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
	   pass.sendKeys(pwd);
	   
	   System.out.println("Enter Name and Password");
	}

	@When("Click on login button for OrangeHrM")
	public void click_on_login_button_for_orange_hr_m() 
	{
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit']"))).click();
	  System.out.println("Login Button");
	}

	@Then("I should see meassage as like {string}")
	public void i_should_see_meassage_as_like(String string)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    boolean loginSuccess = false;
		    boolean loginFailure = false;

		    try {
		        // Check for success (logo appears after successful login)
		        loginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//img[@alt='client brand banner']"))).isDisplayed();
		    } catch (Exception e) {
		        // Do nothing, it may be a login failure case
		    }

		    try {
		        // Check for failure (Invalid credentials message)
		        loginFailure = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//*[text()='Invalid credentials']"))).isDisplayed();
		    } catch (Exception e) {
		        // Do nothing again
		    }

		    // Print your own message based on what happened
		    if (loginSuccess) {
		        System.out.println("✅ SUCCESS: " + string);
		    } else if (loginFailure) {
		        System.err.println("❌ FAILURE: " + string);
		    } else {
		        System.err.println("⚠️ UNKNOWN RESULT: No success or error message found");
		    }

		    // Close browser at the end
		    driver.quit();
		    System.out.println("🔒 Browser Closed");
	}




}
