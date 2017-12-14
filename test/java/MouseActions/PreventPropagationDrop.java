package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreventPropagationDrop extends DroppablePage{

    @FindBy(css = "#draggableprop > p")
    static WebElement draggable;

    @FindBy(css = "#droppable2-inner > p")
    static WebElement greedyInner;

    @FindBy(css = "#droppableprop2 > p")
    static WebElement greedyOuter;

    @FindBy(css = "#droppable-inner > p")
    static WebElement notGreedyInner;

    @FindBy(css = "#droppableprop > p")
    static WebElement notGreedyOuter;
}
