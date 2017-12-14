package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BannerPage {
	
	@FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")
	private WebElement addUser;
	
	@FindBy(css = "body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
	private WebElement login;
	
	public void clickAddUser() {
		addUser.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	

}
