package com.Sdp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.Homepage;
import com.pom.Productpage;

public class SDP {
	public WebDriver driver;
	public Homepage hp;
	public Productpage pg;

	public SDP(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Productpage getProductpage() {
		if (pg == null) {
			pg = new Productpage(driver);
		}
		return pg;
	}

	public Homepage getHomepage() {
		if (hp == null) {
			hp = new Homepage(driver);
		}
		return hp;

	}

}
