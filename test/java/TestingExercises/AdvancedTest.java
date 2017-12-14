package TestingExercises;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AdvancedTest {

    private WebDriver webDriver;
    private static ExtentReports report2;
    private SpreadSheetReader reader2 = new SpreadSheetReader("C:\\Users\\Admin\\eclipse-workspace\\Project1\\TestExamples.xlsx");

    @BeforeClass
    public static void init(){
        report2 = new ExtentReports();
        String fileName = "AdvancedReport" + ".html";
        String filePath = System.getProperty("user.dir")+File.separatorChar + fileName;
        report2.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp(){
        String browser = reader2.readRow(1, "shopSheet").get(1);
        webDriver = WebDriverFactory.getWebDriver(browser);

    }

    @Test
    public void test1(){
        String url1 = reader2.readRow(1,"shopSheet").get(2);
        String asseq = reader2.readRow(1,"shopSheet").get(5);

        ExtentTest test = report2.createTest("1st Test");
        test.log(Status.INFO, "Start of 1st Test");
        webDriver.navigate().to(url1);
        NavBarPage navBar = PageFactory.initElements(webDriver, NavBarPage.class);
        WomenPage womenPage = PageFactory.initElements(webDriver,WomenPage.class);
        test.log(Status.DEBUG, "Clicking women tab");
        navBar.clickWomen();
        test.log(Status.DEBUG, "Applying yellow selection filter");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        womenPage.clickYellow();
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            Assert.assertEquals("Incorrect URL", asseq, webDriver.getCurrentUrl());
            test.pass("Passed");
        }catch (AssertionError Aerr) {

            try {
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "yellowPageURL_ERR");
            } catch (IOException screenShotError) {
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;

        }


    }

   @Test
    public void test2(){

        String url2 = reader2.readRow(2,"shopSheet").get(2);
        String searchQuery = reader2.readRow(2, "shopSheet").get(3);
        String asseq2 = reader2.readRow(2,"shopSheet").get(5);

        ExtentTest test2 = report2.createTest("searchTest");
        test2.log(Status.INFO, "start of blouse search test");

        webDriver.navigate().to(url2);
        NavBarPage navBarPage = PageFactory.initElements(webDriver, NavBarPage.class);
        test2.log(Status.DEBUG, "searching 'blouse'");
        navBarPage.enterSearchQuery(searchQuery + "\n");

        try {
            Assert.assertEquals("Incorrect Search Result", asseq2, webDriver.getCurrentUrl());
            test2.pass("Passed");
        }catch (AssertionError Aerr) {

            try {
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "blouseSearchERR");
            } catch (IOException screenShotError) {
                screenShotError.printStackTrace();
            }
            test2.fail("Failed");
            throw Aerr;

        }


    }

    @Test
    public void test3(){
        String url3 = reader2.readRow(3,"shopSheet").get(2);
        String email3 = reader2.readRow(3,"shopSheet").get(4);
        String asseq3 = reader2.readRow(3,"shopSheet").get(5);
        ExtentTest test3 = report2.createTest("newsletter confirm test");
        test3.log(Status.INFO, "Start of newsletter confirm test");

        webDriver.navigate().to(url3);
        NavBarPage navBarPage = PageFactory.initElements(webDriver, NavBarPage.class);

        test3.log(Status.DEBUG, "entering email3");
        navBarPage.enterEmail(email3);
        test3.log(Status.DEBUG, "clicking confirm subscription button");
        navBarPage.clickNewsConfirm();

        try {
            Assert.assertEquals("Invalid email recognition", asseq3, navBarPage.validEmail.getText());
            test3.pass("Passed");
        }catch (AssertionError Aerr) {

            try {
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "newsLetterSubERR");
            } catch (IOException screenShotError) {
                screenShotError.printStackTrace();
            }
            test3.fail("Failed");
            throw Aerr;

        }


    }

    @Test
    public void test4(){
        String url4 = reader2.readRow(4, "shopSheet").get(2);
        String searchQuery4 = reader2.readRow(4,"shopSheet").get(3);
        String email4 = reader2.readRow(4,"shopSheet").get(4);
        String asseq4 = reader2.readRow(4,"shopSheet").get(5);
        ExtentTest test4 = report2.createTest("invalid search and email test");
        test4.log(Status.INFO, "start of invalid email test");


        webDriver.navigate().to(url4);
        NavBarPage navBarPage = PageFactory.initElements(webDriver, NavBarPage.class);
        TortoiseSearchPage tortoiseSearchPage = PageFactory.initElements(webDriver, TortoiseSearchPage.class);
        test4.log(Status.DEBUG, "searching for 'tortoise' ");
        navBarPage.enterSearchQuery(searchQuery4 + "\n");


        test4.log(Status.DEBUG,"attempting newsletter with invalid email");
        navBarPage.enterEmail(email4);
        navBarPage.clickNewsConfirm();
        try {
            Assert.assertEquals("Invalid search result recognition", asseq4, navBarPage.invalidEmail.getText());
            test4.pass("Passed");
        }catch (AssertionError Aerr) {

            try {
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "invalidEmailERR");
            } catch (IOException screenShotError) {
                screenShotError.printStackTrace();
            }
            test4.fail("Failed");
            throw Aerr;

        }



    }

/*    @Test
    public void test5(){

        String url5 = reader2.readRow(5,"shopSheet").get(2);
        String asseq5 = reader2.readRow(5,"shopSheet").get(5);

        ExtentTest test5 = report2.createTest("cart functionality test");
        test5.log(Status.INFO, "start of cart functionality test");

        webDriver.navigate().to(url5);
        NavBarPage navBarPage = PageFactory.initElements(webDriver, NavBarPage.class);
        DressesPage dressesPage = PageFactory.initElements(webDriver, DressesPage.class);
        PinkPrintedDressPage pinkPrintedDressPage = PageFactory.initElements(webDriver, PinkPrintedDressPage.class);
        EveningDresses eveningDresses = PageFactory.initElements(webDriver, EveningDresses.class);
        CartPage cartPage = PageFactory.initElements(webDriver, CartPage.class);
        test5.log(Status.DEBUG, "Clicking Dresses Button");
        navBarPage.clickDresses();
        test5.log(Status.DEBUG, "Clicking Evening Dresses Button");
        dressesPage.clickEveningDresses();
        test5.log(Status.DEBUG,"Clicking Pink Printed Dress");
        eveningDresses.clickPinkPrinted();

        pinkPrintedDressPage.ClickAddToCart();
        webDriver.navigate().to(url5);
        navBarPage.clickCart();





    }*/

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp(){
        report2.flush();
    }
}

