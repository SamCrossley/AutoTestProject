package TestingExercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(String browser){
        if ("Chrome".equalsIgnoreCase(browser)){
            return new ChromeDriver();
        }else if ("Firefox".equalsIgnoreCase(browser)){
            return new FirefoxDriver();

        }else{
            return new ChromeDriver();
        }
    }
}
