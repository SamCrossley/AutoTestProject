package MouseActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultSelect {

    @FindBy(css ="#selectable > li:nth-child(1)")
    static WebElement item1;

    @FindBy(css = "#selectable > li:nth-child(2)")
    static WebElement item2;

    @FindBy(css = "#selectable > li:nth-child(3)")
    static WebElement item3;

    @FindBy(css = "#selectable > li:nth-child(4)")
    static WebElement item4;

    @FindBy(css = "#selectable > li:nth-child(5)")
    static WebElement item5;

    @FindBy(css = "#selectable > li:nth-child(6)")
    static WebElement item6;

    public void click1(){
        item1.click();
    }
    public void click2(){
        item2.click();
    }
    public void click3(){
        item3.click();
    }
    public void click4(){
        item4.click();
    }
    public void click5(){
        item5.click();
    }
    public void click6(){
        item6.click();
    }


}
