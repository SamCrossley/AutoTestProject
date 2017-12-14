package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage extends NavBarPage {

    @FindBy(css = "#layered_id_attribute_group_16")
    private WebElement yellow;

    @FindBy(css = "#list > a > i")
    private WebElement listView;


    @FindBy(css = "#enabled_filters > ul > li > a > i")
    private WebElement removeYellowFilter;



    @FindBy(css = "#center_column > ul > li.ajax_block_product.last-line.last-item-of-tablet-line.last-mobile-line.col-xs-12 > div > div > div.right-block.col-xs-4.col-xs-12.col-md-4 > div > div.button-container.col-xs-7.col-md-12 > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    private WebElement addToCart;

    public void clickYellow(){
        yellow.click();
    }
    public void clickRemoveYellow(){
        removeYellowFilter.click();
    }
    public void clickAddDress2ToCart(){
        addToCart.click();
    }
    public void clickList(){
        listView.click();
    }

}
