package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultFunctionalityDrop extends DroppablePage {

    @FindBy(css = "#draggableview")
    static WebElement dragBox;

    @FindBy(css = "#droppableview")
    static WebElement dropBox;

}
