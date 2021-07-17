package com.selenium.sync;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationDemo {

	public static void main(String[] args) throws InterruptedException {
		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		WebDriver driver = new ChromeDriver();
		// Implicit wait time
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Explicit wait time
		WebDriverWait wait = new WebDriverWait(driver, 5);

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		Thread.sleep(3000);

		addItems(driver, itemsNeeded);
		// Click Cart icon
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		// Click check out button
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		// Explicit wait time
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		// Enter promotion code
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		// Click apply button
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		// Get text of promotion information
		String promoInfo = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println(promoInfo);
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;
		// Get product lists
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
	
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length)
					break;
			}

		}
	}

}
