package com.selenium.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_07 {

	public static void main(String[] args) {
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
		
		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		
		jsExe.executeScript("window.scrollBy(0, 600)");
		
		WebElement productTable = driver.findElement(By.id("product"));
		
		List<WebElement> tableRows = productTable.findElements(By.tagName("tr"));
		System.out.println("Table Rows: " + tableRows.size());
		
		List<WebElement> tableColumns = productTable.findElements(By.tagName("th"));		
		System.out.println("Table Columns: " + tableColumns.size());

		List<WebElement> secondRow = tableRows.get(2).findElements(By.tagName("td"));
		System.out.println(secondRow.get(0).getText());
		System.out.println(secondRow.get(1).getText());
		System.out.println(secondRow.get(2).getText());
	}

}
