package com.stefdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Baseclass;
import com.properties.ConfigurationHelper;
import com.runner.Runnerclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Stepdefinition extends Baseclass{
	public static WebDriver driver=Runnerclass.driver;
	public static String attribute;
	
	
	@Given("^user Launch The Url$")
	public void user_Launch_The_Url() throws Throwable {
		//driver.get("https://www.amazon.in/");
		String url = ConfigurationHelper.getInstance().getUrl();
		launchURL(url);
		//implicityWait();
	}

	@When("^user Screach Baby Product and Type Product Name$")
	public void user_Screach_Baby_Product_and_Type_Product_Name() throws Throwable {
WebElement s1 = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
		
		String b1 = "Baby";
		Select s = new Select(s1);
		Thread.sleep(3000);
		List<WebElement> options2 =dropDownOptions(s1);
		Thread.sleep(1000);
		for (int i = 0; i < options2.size(); i++) {
			String text = options2.get(i).getText();
			if (b1.equalsIgnoreCase(text)) {
				dropdownSelect(s1, text, b1);
				break;
			} else {
				continue;
			}

		}
	}

	@When("^user Select The Product Name and Find Total Product$")
	public void user_Select_The_Product_Name_and_Find_Total_Product() throws Throwable {
		Thread.sleep(2000);
		WebElement link = driver.findElement(By.xpath("//input[@type='text']"));
		userInput(link, "toys");
		//link.sendKeys("toys");
		attribute = link.getAttribute("value");

		Thread.sleep(3000);
	}

	@Then("^user Find All Product Name and execute$")
	public void user_Find_All_Product_Name_and_execute() throws Throwable {
		List<WebElement> v2 = driver
				.findElements(By.xpath("//div[@role='button']"));
		Thread.sleep(3000);
		for (WebElement web : v2) {
			String text = getTextOnElement(web);
			if (attribute.contains(text)) {
				Thread.sleep(3000);
				//web.click();
				clickOnElement(web);
				break;
			}
			
		}
		List<WebElement> results = driver
				.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']"));
		int size = results.size();
		System.out.println(size);
		Thread.sleep(3000);
	}

}
