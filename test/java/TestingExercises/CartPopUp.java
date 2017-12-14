package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopUp {

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span" )
    private WebElement checkout;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
    private WebElement contShopping;

    public void clickCheckOut(){
        checkout.click();
    }
    public void clickContShop(){
        contShopping.click();
    }
}
