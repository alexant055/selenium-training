package com.selenium.automation.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
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

		// Select Region
		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(3000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		// Select FROM and TO
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.click();

		// Select start date
		driver.findElement(By.cssSelector("[class*='ui-state-highlight']")).click();

		// Select return date
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			driver.findElement(By.id("Div1")).click();
			driver.findElement(By.cssSelector("[class*='ui-state-highlight']")).click();
		}

		// Select passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		int counter = 1;
		while (counter < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			counter++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		// Select Currency
		WebElement currencyElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select selectOptions = new Select(currencyElement);
		selectOptions.selectByValue("INR");

		// Select passenger offer category
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	}

}
