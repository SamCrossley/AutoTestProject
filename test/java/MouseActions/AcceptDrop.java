package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AcceptDrop extends DroppablePage{

    @FindBy(css = "#draggableaccept > p")
    static WebElement dragAndDrop;

    @FindBy(css = "#droppableaccept")
    static WebElement dropBox;

    @FindBy(css = "#draggable-nonvalid > p")
    static WebElement dragNotDrop;
}

