package com.consulting.qa.Project1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverTest {
	
	private WebDriver webDriver;
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
	}

	@Test
	public void driverTest() {
		webDriver.navigate().to("https://www.google.co.uk"); // navigates to google
		GooglePage googlePage = PageFactory.initElements(webDriver, GooglePage.class);
		googlePage.enterQuery("QA\n");
		googlePage.clickQALink();
		//WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib")); // finds the searchbar element (and creates it as a variable) by using its css selector (inspected element on the webpage)
		//searchBar.sendKeys("QA\n"); //inputs the search value
		/*try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ // basic way to make it wait
		//WebElement QALink = webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > h3 > a"));
		//QALink.click();

		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		QAHomepage qaHomePage = PageFactory.initElements(webDriver,  QAHomepage.class);
		qaHomePage.clickConsulting();
		
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		qaHomePage.clickGrad();
		Assert.assertEquals("Incorrect URL found", "https://consulting.qa.com/graduate-programme", webDriver.getCurrentUrl());

	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
}

