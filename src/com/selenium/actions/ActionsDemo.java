package com.selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		String applicationUrl = "https://www.amazon.com/";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();
		// Maximize the screen
		driver.manage().window().maximize();

		driver.get(applicationUrl);

		Actions actions = new Actions(driver);

		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

		// Moves to specific element
		actions.moveToElement(move).build().perform();
	}

}
