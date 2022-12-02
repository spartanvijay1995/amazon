package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	public WebDriver driver;
	
	@FindBy(xpath ="//input[@type='text']" )
	private WebElement link;
	
	@FindBy(xpath = "//div[@role='button']")
	private List<WebElement> v2;
	
	@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']\"")
	private WebElement results;

	

	



	public Productpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getlink() {
		return link;
	}

	public List<WebElement> getv2() {
		return v2;
	}

	public WebElement getresults() {
		return results;
	}

	





	public WebElement getLink() {
		return link;
	}

	public List<WebElement> getV2() {
		return v2;
	}

	public WebElement getResults() {
		return results;
	}
	
	
	
	

}
