package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConnectListSort {

    @FindBy(css = "#sortable1 > li:nth-child(1)")
    static WebElement item1_1;
    @FindBy(css = "#sortable1 > li:nth-child(2)")
    static WebElement item1_2;
    @FindBy(css = "#sortable1 > li:nth-child(3)")
    static WebElement item1_3;
    @FindBy(css = "#sortable1 > li:nth-child(4)")
    static WebElement item1_4;
    @FindBy(css = "#sortable1 > li:nth-child(5)")
    static WebElement item1_5;

    @FindBy(css = "#sortable2 > li:nth-child(1)")
    static WebElement item2_1;
    @FindBy(css = "#sortable2 > li:nth-child(2)")
    static WebElement item2_2;
    @FindBy(css = "#sortable2 > li:nth-child(3)")
    static WebElement item2_3;
    @FindBy(css = "#sortable2 > li:nth-child(4)")
    static WebElement item2_4;
    @FindBy(css = "#sortable2 > li:nth-child(5)")
    static WebElement item2_5;



}
