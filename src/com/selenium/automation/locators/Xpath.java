package com.selenium.automation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {
		String applicationUrl = "https://www.facebook.com";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();

		driver.get(applicationUrl);

		driver.findElement(By.id("email")).sendKeys("facebookemail");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("enterpassword");

		driver.findElement(By.xpath("//button[@name='login']")).click();

	}

}
