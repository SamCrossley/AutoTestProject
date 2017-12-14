package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BannerPage {

	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
	private WebElement usernameBar;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
	private WebElement passwordBar;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
	static 
	WebElement successfulBox;
	
	@FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	private WebElement loginButton;
	
	public void enterUsername(String username) {
		usernameBar.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordBar.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	
}
