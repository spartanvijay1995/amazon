package com.featureamazon.amazon.c;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Sdp.SDP;

import com.base.Baseclass;
import com.pom.Homepage;
import com.pom.Productpage;
import com.properties.ConfigurationHelper;

public class Amazon_task extends Baseclass {

	public static void main(String[] args) throws InterruptedException, IOException {
		String browser = ConfigurationHelper.getInstance().getBrowser();

		Baseclass.browserlaunch(browser);
		SDP sd=new SDP(driver);

		String url = ConfigurationHelper.getInstance().getUrl();
		launchURL(url);
		// driver.get("https://www.amazon.in/");
//		WebElement s1 = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

		String b1 = "Baby";
		//dropDownOptions(s1);
		Select s = new Select(sd.getHomepage().getS1());
		Thread.sleep(3000);
		List<WebElement> options2 = dropDownOptions(sd.getHomepage().getS1());
		Thread.sleep(1000);

		for (int i = 0; i < options2.size(); i++) {
			String text = options2.get(i).getText();
			if (b1.equalsIgnoreCase(text)) {
				dropdownSelect(sd.getHomepage().getS1(), "text", b1);
				break;
			} else {
				continue;
			}

		}
		Thread.sleep(2000);
		//WebElement link = driver.findElement(By.xpath("//input[@type='text']"));
		userInput(sd.getProductpage().getLink(), "toys");
		// link.sendKeys("toys");
		String attribute = sd.getProductpage().getLink().getAttribute("value");

		Thread.sleep(3000);

		List<WebElement> toy = sd.getProductpage().getV2();
		Thread.sleep(3000);
		for (WebElement web : toy) {
			String text = getTextOnElement(web);
			System.out.println(text);
			if (attribute.contains(text)) {
				Thread.sleep(3000);
				clickOnElement(web);
				// web.click();
				break;
			}

		}
		Thread.sleep(3000);

		Thread.sleep(3000);
		

	}

}
