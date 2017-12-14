package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage {

    @FindBy(css = "#ui-id-2")
    private WebElement accept;

    @FindBy(css = "#ui-id-3")
    private WebElement preventPropagation;

    @FindBy(css = "#ui-id-4")
    private WebElement revertDP;

    @FindBy(css = "#ui-id-5")
    private WebElement shoppingCart;

    public void clickAccept(){
        accept.click();
    }
    public void clickPP(){
        preventPropagation.click();
    }
    public void clickRevertDP(){
        revertDP.click();
    }
    public void clickShoppingCart(){
        shoppingCart.click();
    }
}
