package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends NavBarPage {

    @FindBy(css = "#summary_products_quantity")
    static WebElement quantity;
}
