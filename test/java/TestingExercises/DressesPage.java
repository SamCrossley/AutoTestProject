package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DressesPage extends NavBarPage {


    @FindBy(css = "#categories_block_left > div > ul > li:nth-child(2) > a")
    private WebElement eveningDresses;


    public void clickEveningDresses(){
        eveningDresses.click();
    }


}
