package com.TestNg;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Baseclass;



public class AmazonTestNg extends Baseclass {
	
	@BeforeClass
	private void browserSetUp() {
		browserlaunch("chrome");
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\admin\\eclipse-workspace\\flipkartnew\\driver\\chromedriver1.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();

	}

	

	@BeforeClass
	private void urlLaunch() {
		launchURL("https://www.amazon.in/");
		//driver.get("https://www.flipkart.com/");

	}

	@Test(priority = 0)
	private void productName() throws IOException, InterruptedException {
		WebElement s1 = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

		String b1 = "Baby";
		//dropDownOptions(s1);
		Select s = new Select(s1);
		Thread.sleep(1000);
		List<WebElement> options2 = dropDownOptions(s1);
		Thread.sleep(1000);

		for (int i = 0; i < options2.size(); i++) {
			String text = options2.get(i).getText();
			if (b1.equalsIgnoreCase(text)) {
				dropdownSelect(s1, "text", b1);
				break;
			} else {
				continue;
			}

		}
	}

	@Test(priority = 1)
	private void allProductName() throws InterruptedException {
		WebElement link = driver.findElement(By.xpath("//input[@type='text']"));
		userInput(link, "toys");
		// link.sendKeys("toys");
		String attribute = link.getAttribute("value");

		Thread.sleep(3000);

		List<WebElement> v2 = driver.findElements(By.xpath("//div[@role='button']"));
		Thread.sleep(3000);
		for (WebElement web : v2) {
			String text = getTextOnElement(web);
			System.out.println(text);
			if (attribute.contains(text)) {
				Thread.sleep(3000);
				clickOnElement(web);
				// web.click();
				break;
			}

		}

	}

	@Test(dependsOnMethods = "allProductName")
	private void totalNumberOfProduct() throws InterruptedException {
		List<WebElement> results = driver
				.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']"));
		int size = results.size();
		System.out.println(size);
		Thread.sleep(3000);
	}

	@AfterClass
	private void urlClose() {
		driver.manage().deleteAllCookies();

	}
	@AfterTest
	private void browserclose() {
		driver.close();
		

	}

}
