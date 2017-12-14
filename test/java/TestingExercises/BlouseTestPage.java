package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class BlouseTestPage extends NavBarPage {

    @FindBy(css = "#informations_block_left_1 > div > ul > li:nth-child(4) > a")
    private WebElement aboutUs;

    @FindBy(css = "#center_column > ul > li > div > div > div.right-block.col-xs-4.col-xs-12.col-md-4 > div > div.button-container.col-xs-7.col-md-12 > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    private WebElement addToCart;

    @FindBy(css = "#center_column > h1 > span.lighter")
    static WebElement searchResult;

    public void clickAddToCart(){
        addToCart.click();
    }
}
