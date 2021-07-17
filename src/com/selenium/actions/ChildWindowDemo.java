package com.selenium.actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowDemo {

	public static void main(String[] args) {
		String applicationUrl = "https://rahulshettyacademy.com/loginpagePractise/#";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();
		// Maximize the screen
		driver.manage().window().maximize();

		driver.get(applicationUrl);
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		// Get window IDs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		
		// Switching to child window
		driver.switchTo().window(childWindow);
		
		String emailText = driver.findElement(By.cssSelector(".im-para.red")).getText();

		String emailID = emailText.split("at")[1].trim().split(" ")[0];
		
		// Switching to Parent window
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.id("username")).sendKeys(emailID);
	}

}
