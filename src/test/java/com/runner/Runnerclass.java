package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.Baseclass;
import com.properties.ConfigurationHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	@RunWith(Cucumber.class)
	@CucumberOptions(features = "C:\\Users\\admin\\eclipse-workspace\\amazon.c\\src\\test\\java\\com\\feature\\amazon.feature",
	glue="com.stefdefinition",
	monochrome = true
	,dryRun =false)

	public class Runnerclass {
		
		public static WebDriver driver =null;
		@BeforeClass
		public static void setup() throws IOException {
			String browser = ConfigurationHelper.getInstance().getBrowser();
			driver=Baseclass.browserlaunch(browser);
			//Baseclass.launchURL("https://www.amazon.in/");
			
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\admin\\eclipse-workspace\\newfacebook\\driver\\chromedriver1.exe");
//			driver = new ChromeDriver();
//			driver.manage().window().maximize();
//			//driver.get("https://www.flipkart.com/");
		}
		@AfterClass
		public static void teardown() {
			//driver.close();
			Baseclass.close();

		}
	}

