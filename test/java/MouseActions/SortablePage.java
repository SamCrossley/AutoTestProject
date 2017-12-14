package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortablePage {

    @FindBy(css = "#ui-id-2")
private WebElement connectLists;

    @FindBy(css = "#ui-id-3")
    private WebElement gridDisplay;

    @FindBy(css = "#ui-id-4")
    private WebElement portlets;

    public void clickConnectLists(){
        connectLists.click();
    }
    public void clickGridDisplay(){
        gridDisplay.click();
    }
    public void clickPortlets(){
        portlets.click();
    }
}
