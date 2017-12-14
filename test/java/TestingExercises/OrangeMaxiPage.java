package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeMaxiPage extends NavBarPage {

    @FindBy(css = "#group_1")
    private WebElement sizeSelector;

    @FindBy(css = "#availability_value")
    private WebElement stock;
}
