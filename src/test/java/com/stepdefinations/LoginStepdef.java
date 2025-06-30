package com.stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginStepdef 
{

	WebDriver driver;
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		System.out.println("this is home page");
  
	}
	
	@When("User Navigate to LogIn Page")
	public void user_navigate_to_log_in_page() {
    
		System.out.println("Navigating to login page");
		//WebDriverManager.chromedriver().setup();
		
	}
	
	@When("User enters UserName and Password")
	public void user_enters_user_name_and_password() {
  
		driver.findElement(By.id("uname")).clear();
		driver.findElement(By.id("uname")).sendKeys("auth_user");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("auth_password");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		System.out.println("Entering username and password");
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
		System.out.println("Login success");
		//driver.close();
		//System.out.println("*********** Browser Closed *****************");
	}
	
	@When("User LogOut from the Application")
	public void user_log_out_from_the_application() {
		System.out.println("click on the logout button");
   
	}

	@Then("Message displayed LogOut Successfully")
	public void message_displayed_log_out_successfully() {
		System.out.println("logout success");
		//driver.close();
		System.out.println("******** Closed **********");
	}
	
}
