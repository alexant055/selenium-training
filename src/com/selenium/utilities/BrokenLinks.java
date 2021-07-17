package com.selenium.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		String applicationUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();
		
		// Maximize the screen
		driver.manage().window().maximize();

		driver.get(applicationUrl);
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		List<WebElement> links = footer.findElements(By.tagName("a"));
		
		for(WebElement link: links) {
			HttpURLConnection connection = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			
			if(responseCode >= 400)
				System.out.println("Broken Link: " + link.getAttribute("href"));
		}
		
	}

}
