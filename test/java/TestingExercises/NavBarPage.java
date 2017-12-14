package TestingExercises;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NavBarPage {

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement women;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    private WebElement dresses;

    @FindBy(css = "#block_top_menu > ul > li.sfHoverForce > a")
    private WebElement tshirts;

    @FindBy(css = "#search_query_top")
    private WebElement searchBar;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private WebElement cart;

    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    private WebElement signIn;

    @FindBy(css = "#newsletter_block_left > div > form > div > button")
    private WebElement newsletterConfirm;

    @FindBy(css = "#newsletter-input")
    private WebElement emailInput;

    @FindBy(css = "#columns > p")
    static WebElement invalidEmail;

    @FindBy(css = "#columns > p")
    static WebElement validEmail;

    @FindBy(css = "#header_logo > a > img")
    private WebElement home;

    public void clickWomen(){
        women.click();
    }
    public void clickDresses(){
        dresses.click();
    }
    public void clickTShirts(){
        tshirts.click();
    }
    public void enterSearchQuery(String query){
        searchBar.sendKeys(query);
    }
    public void clickCart(){
        cart.click();
    }
    public void clickSignIn(){
        signIn.click();
    }
    public void clickNewsConfirm(){
        newsletterConfirm.click();
    }
    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }
    public void clickHome(){
        home.click();
    }
}
