package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PinkPrintedDressPage extends NavBarPage {

    @FindBy(css = "#add_to_cart > button > span")
    private WebElement addToCartButton;

    public void ClickAddToCart(){
        addToCartButton.click();
    }
}
