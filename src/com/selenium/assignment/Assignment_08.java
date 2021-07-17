package com.selenium.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_08 {

	public static void main(String[] args) throws InterruptedException {
		String applicationUrl = "http://qaclickacademy.com/practice.php";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();
		// Maximize the screen
		driver.manage().window().maximize();

		driver.get(applicationUrl);
		
		WebElement inputElement = driver.findElement(By.id("autocomplete"));
		
		inputElement.sendKeys("ind");
		
		Thread.sleep(3000);
		
		List<WebElement> suggestedItems = driver.findElements(By.cssSelector("[class='ui-menu-item-wrapper']"));
		
		for(WebElement item: suggestedItems) {
			System.out.println(item.getText());
		}
		
		suggestedItems.get(1).click();
		
		System.out.println(inputElement.getAttribute("value"));
		
		if(inputElement.getAttribute("value").equalsIgnoreCase("India")) 
			System.out.println("It's matched!");
		else
			System.out.println("Something wrong!");
		
	}
}
