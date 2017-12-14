package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TortoiseSearchPage extends NavBarPage {

    @FindBy(css = "#center_column > p")
    static WebElement noResults;


}
