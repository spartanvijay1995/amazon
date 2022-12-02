package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage  {
	public static WebDriver driver;
	
	@FindBy (xpath ="//select[@aria-describedby='searchDropdownDescription']")
	private WebElement s1;

	
	

	

	public Homepage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}



	
	public WebElement getS1() {
		return s1;
	}

	
	
	
}
