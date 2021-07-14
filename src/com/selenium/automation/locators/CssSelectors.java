package com.selenium.automation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectors {

	public static void main(String[] args) {
		String applicationUrl = "https://www.facebook.com";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();
		// Maximize the screen
		driver.manage().window().maximize();

		driver.get(applicationUrl);
		// Enter email
		driver.findElement(By.id("email")).sendKeys("facebookemail");
		// Enter password
		driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("enterpassword");
		// Click login button
		driver.findElement(By.cssSelector("button[name='login']")).click();

		driver.quit();
	}
}
