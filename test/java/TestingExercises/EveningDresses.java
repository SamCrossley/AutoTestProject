package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EveningDresses extends NavBarPage {

    @FindBy(css = "#color_43")
    private WebElement pinkPrinted;

    public void clickPinkPrinted(){
        pinkPrinted.click();
    }
}
