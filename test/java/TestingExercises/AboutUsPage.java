package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends NavBarPage {

    @FindBy(css = "#newsletter_block_left > div > form > div > button")
    private WebElement newsletterConfirm;

    @FindBy(css = "#columns > p")
    private WebElement invalidEmail;


}
