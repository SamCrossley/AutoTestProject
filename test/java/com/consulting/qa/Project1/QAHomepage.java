package com.consulting.qa.Project1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QAHomepage {
	
	@FindBy(css = "#carousel-consulting")
	private WebElement consulting;
	
	@FindBy(css = "#main > div > div > div > div.hero-banner.owl-carousel.owl-theme.owl-loaded > div.owl-stage-outer.owl-height > div > div.owl-item.active > div > div.body-skin.left > div > a:nth-child(4)")
	private WebElement grad;
	
	public void clickConsulting() {
		consulting.click();
	}
	
	public void clickGrad() {
		grad.click();
	}
	

}
