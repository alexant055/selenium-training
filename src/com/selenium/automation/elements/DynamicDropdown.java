package com.selenium.automation.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
	public static void main(String[] args) {
		String applicationUrl = "https://rahulshettyacademy.com/dropdownsPractise/";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();
		// Maximize the screen
		driver.manage().window().maximize();

		driver.get(applicationUrl);
		// Option 1
//		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		
//		driver.findElement(By.xpath("//a[@value='MAA']")).click();
//		
//		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
//		
//		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();

		// Option 2 - Recommended
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.click();
	}
}
