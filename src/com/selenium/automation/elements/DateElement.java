package com.selenium.automation.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateElement {

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

		// Select FROM and TO
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='MAA']")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.click();

		// Select date
		driver.findElement(By.cssSelector("[class*='ui-state-highlight']")).click();

		// Verify one way or round trip
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("One Way!");
		} else {
			System.out.println("Round Trip!");
		}

		// Select round trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// Verify one way or round trip
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("One Way!");
		} else {
			System.out.println("Round Trip!");
		}

		// Select return date
		driver.findElement(By.id("Div1")).click();
		driver.findElement(By.cssSelector("[class*='ui-state-highlight']")).click();
	}

}
