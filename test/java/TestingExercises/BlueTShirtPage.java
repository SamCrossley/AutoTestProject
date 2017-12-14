package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlueTShirtPage extends NavBarPage {

    @FindBy(css = "#add_to_cart > button > span")
    private WebElement addToCart;

    public void clickAddToCart(){
        addToCart.click();
    }
}
