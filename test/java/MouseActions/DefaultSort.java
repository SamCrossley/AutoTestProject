package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultSort {

    @FindBy(css = "#sortable > li:nth-child(1)")
     WebElement item1 ;

    @FindBy(css = "#sortable > li:nth-child(2)")
     WebElement item2;

    @FindBy(css = "#sortable > li:nth-child(3)")
     WebElement item3;

    @FindBy(css = "#sortable > li:nth-child(4)")
     WebElement item4;

    @FindBy(css = "#sortable > li:nth-child(5)")
     WebElement item5;

    @FindBy(css = "#sortable > li:nth-child(6)")
     WebElement item6;

    @FindBy(css = "#sortable > li:nth-child(7)")
     WebElement item7;
}
