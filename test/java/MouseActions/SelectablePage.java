package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectablePage {

    @FindBy(css = "#ui-id-1")
    private WebElement defaultSel;

    @FindBy(css = "#ui-id-2")
    private WebElement gridDisplay;

    @FindBy(css = "#ui-id-3")
    private WebElement serialise;

    public void clickDefault(){
        defaultSel.click();
    }
    public void clickGrid(){
        gridDisplay.click();
    }
    public void clickserialise(){
        serialise.click();
    }
}
