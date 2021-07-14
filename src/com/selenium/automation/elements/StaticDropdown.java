package com.selenium.automation.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

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

		WebElement currencyElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select selectOptions = new Select(currencyElement);

		selectOptions.selectByIndex(3);
		System.out.println(selectOptions.getFirstSelectedOption().getText());

		selectOptions.selectByValue("INR");
		System.out.println(selectOptions.getFirstSelectedOption().getText());

		selectOptions.selectByVisibleText("AED");
		System.out.println(selectOptions.getFirstSelectedOption().getText());
	}

}
