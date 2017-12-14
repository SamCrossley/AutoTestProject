package com.consulting.qa.Project1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {
	
	@FindBy(css = "#lst-ib")
	private WebElement searchBar;
	
	@FindBy(css = "#rso > div:nth-child(1) > div > div > div > div > h3 > a")
	private WebElement QALink;
	
	public void enterQuery(String query) {
		searchBar.sendKeys(query);
	}

	public void clickQALink() {
		QALink.click();
	}
}
