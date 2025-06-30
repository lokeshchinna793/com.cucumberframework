package com.stepdefinations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpAndTearDown 
{
	static WebDriver driver;
	@Before
	public void Setup()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://ecommerce.artoftesting.com/");
		
		driver.manage().window().maximize();
		
		System.out.println("Before Each Scenario");
	}
	
	@After
	public void Teardown()
	{
		driver.close();
		System.out.println("After Each Scenario");
	}
	
	@BeforeAll
	public static void beforeAll()
	{
		System.out.println("****** Before  Run All Scenarios ******");
	}
	
	@AfterAll
	public static void afterAll()
	{
		System.out.println("****** After  Run All Scenarios ******");
	}
	
	
	@BeforeStep
	public void beforeStep()
	{
		System.out.println("###### Before Each Step ######");
	}
	
	@AfterStep
	public void afterStep()
	{
		System.out.println("###### After Each Step   ######");
	}
}
