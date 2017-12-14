package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridDisplaySort {

    @FindBy(css = "#sortable_grid > li:nth-child(1)")
    static WebElement item1;

    @FindBy(css = "#sortable_grid > li:nth-child(6)")
    static WebElement item6;
}
