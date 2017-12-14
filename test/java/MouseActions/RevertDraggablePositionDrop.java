package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RevertDraggablePositionDrop extends DroppablePage {

    @FindBy(css = "#draggablerevert > p")
    static WebElement revertWhenDropped;

    @FindBy(css = "#draggablerevert2 > p")
    static WebElement revertWhenNotDropped;

    @FindBy(css = "#droppablerevert")
    static WebElement dropBox;
}
