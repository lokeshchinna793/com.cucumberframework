package com.stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import static com.stepdefinations.SetUpAndTearDown.driver;

public class LoginArtoftestingEcom  
{

	@Given("browser should be open and naviagted to art of testing ecommerce website")
	public void browser_should_be_open_and_naviagted_to_art_of_testing_ecommerce_website() 
	{
		 	System.out.println("browser opened and we are in ecommerce website");
	}

	@When("enter valid username and valid password")
	public void enter_valid_username_and_valid_password() 
	{
		driver.findElement(By.id("uname")).clear();
		driver.findElement(By.id("uname")).sendKeys("auth_user");
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("auth_password");
		
	}

	@When("Click on login button")
	public void click_on_login_button() 
	{
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    
	}

	@Then("verify login successfull")
	public void verify_login_successfull() throws InterruptedException 
	{
			String expectedtitle="ArtOfTesting Ecom";
			String actualtitle=driver.findElement(By.xpath("//*[text()='ArtOfTesting Ecom']")).getText();
			Assert.assertEquals("Title is not matching",actualtitle , expectedtitle);
			
			driver.findElement(By.xpath("//*[text()='Logout']")).click();
			
			driver.navigate().refresh();
			
			Thread.sleep(5000);
	}
	
	@When("enter valid username and invalid password")
	public void enter_valid_username_and_invalid_password() 
	{
		driver.findElement(By.id("uname")).clear();
		driver.findElement(By.id("uname")).sendKeys("auth_user");
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("auth_passw");
	}

	@Then("verify login unsuccessfull")
	public void verify_login_unsuccessfull() 
	{
		String expectederror="Invalid username or password!";
	   String Actualerror=driver.findElement(By.xpath("//*[text()='Invalid username or password!']")).getText();
	   Assert.assertEquals("error is not matching",Actualerror , expectederror);
	  
	}

}
