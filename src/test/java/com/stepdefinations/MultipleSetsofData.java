package com.stepdefinations;

import static com.stepdefinations.SetUpAndTearDown.driver;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleSetsofData 
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		
		driver.findElement(By.id("uname")).clear();
		driver.findElement(By.id("uname")).sendKeys(username);
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@Then("I should see {string}")
	public void i_should_see(String string) throws InterruptedException 
	{
		if(string.equalsIgnoreCase("ArtOfTesting Ecom"))
			{
			WebElement Successmessage=driver.findElement(By.xpath("//*[text()='ArtOfTesting Ecom']"));
			wait.until(ExpectedConditions.visibilityOf(Successmessage));
			String actualtitle=Successmessage.getText();	
			Assert.assertEquals("Title is not matching",actualtitle , string);
			
			WebElement logoutele=driver.findElement(By.xpath("//*[text()='Logout']"));
			
			wait.until(ExpectedConditions.visibilityOf(logoutele));
			logoutele.click();
			}
	
		else
			{
			WebElement errorelem=driver.findElement(By.xpath("//*[text()='Invalid username or password!']"));
			wait.until(ExpectedConditions.visibilityOf(errorelem));
			
			String Actualerror=errorelem.getText();
			Assert.assertEquals("error is not matching",Actualerror , string);
			}
		  
		  
		   
	}

}
