package com.selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_06 {

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
		
		WebElement optionElement = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]"));
		
		optionElement.findElement(By.tagName("input")).click();
		
		String optionText = optionElement.getText();
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText(optionText);
		
		driver.findElement(By.id("name")).sendKeys(optionText);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		
		if(alertText.contains(optionText))
			System.out.println("Alert message success");
		else
			System.out.println("somthing wrong");
	}

}
