package MouseActions;

import TestingExercises.ScreenShot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class SelectableTest {

    private WebDriver webDriver;
    private static ExtentReports report;
    private Actions builder;
    private SelectablePage page;



    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        String fileName = "SelectableTestReport" + ".html";
        String filePath = System.getProperty("user.dir")+ File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }
    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        builder = new Actions(webDriver);
        page = PageFactory.initElements(webDriver, SelectablePage.class);

    }
    @Test
    public void defaultOneClickTest(){
        ExtentTest test = report.createTest("DefaultSelectorTest1");
        test.log(Status.INFO, "Starting Default Test 1");

        webDriver.navigate().to("http://demoqa.com/selectable/");
        DefaultSelect defaultSelect = PageFactory.initElements(webDriver, DefaultSelect.class);
        test.log(Status.DEBUG, "selecting Item 1");
        defaultSelect.click1();


        String aClass = defaultSelect.item1.getAttribute("class");
        boolean pass = false;
        if (aClass.contains("selected")) {
            pass = true;
        }
        try {
            Assert.assertEquals("Item1 not selected", true, pass);
            test.pass("Passed");
        }catch(AssertionError Aerr){
            try{              ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "defSel_ERR1");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }
        }
@Test
public void defaultHighlightTest(){
        ExtentTest test = report.createTest("defaultHighlightTest");
        test.log(Status.INFO, "Starting Default Test 2");
        DefaultSelect defaultSelect = PageFactory.initElements(webDriver, DefaultSelect.class);

        webDriver.navigate().to("http://demoqa.com/selectable/");
        test.log(Status.DEBUG,"highlighting items 1 through 6");
        builder.clickAndHold(defaultSelect.item1).release(defaultSelect.item6).perform();

        String aClass = defaultSelect.item1.getAttribute("class");
        boolean pass1 = false;
        if (aClass.contains("selected")){
            pass1 = true;
        }
        String bClass = defaultSelect.item2.getAttribute("class");
        boolean pass2 = false;
        if (bClass.contains("selected")){
            pass2 = true;
        }
        String cClass = defaultSelect.item3.getAttribute("class");
        boolean pass3 = false;
        if (cClass.contains("selected")){
            pass3 = true;
        }
        String dClass = defaultSelect.item4.getAttribute("class");
        boolean pass4 = false;
        if(dClass.contains("selected")){
            pass4 = true;
        }
         String eClass = defaultSelect.item5.getAttribute("class");
        boolean pass5 = false;
        if(dClass.contains("selected")){
        pass5 = true;
        }
        String fClass = defaultSelect.item6.getAttribute("class");
        boolean pass6 = false;
        if(dClass.contains("selected")){
        pass6 = true;
        }
        try {
            Assert.assertEquals("Not all values selected", true, pass1 && pass2 && pass3 && pass4 && pass5 && pass6);
            test.pass("Passed");
        }catch(AssertionError Aerr){
            try{
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "defSel_ERR2");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }

}
@Test
public void defMultiClickTest(){
    ExtentTest test = report.createTest("defaultMultiClickTest");
    test.log(Status.INFO, "Starting Default Test 3");
    DefaultSelect defaultSelect = PageFactory.initElements(webDriver, DefaultSelect.class);

    webDriver.navigate().to("http://demoqa.com/selectable/");
    test.log(Status.DEBUG,"clicking Item 2");
    builder.keyDown(Keys.LEFT_CONTROL).perform();
    defaultSelect.click1();
    defaultSelect.click4();
    defaultSelect.click5();
    builder.keyUp(Keys.LEFT_CONTROL).perform();

    String aClass = defaultSelect.item1.getAttribute("class");
    boolean pass1 = false;
    if (aClass.contains("selected")){
        pass1 = true;
    }
    String bClass = defaultSelect.item4.getAttribute("class");
    boolean pass2 = false;
    if (bClass.contains("selected")){
        pass2 = true;
    }
    String cClass = defaultSelect.item5.getAttribute("class");
    boolean pass3 = false;
    if (cClass.contains("selected")){
        pass3 = true;
    }
    try {
        Assert.assertEquals("Not all values selected", true, pass1 && pass2 && pass3);
        test.pass("Passed");
    }catch(AssertionError Aerr){
        try{
            ScreenShot screenShot = new ScreenShot();
            screenShot.take(webDriver, "defSel_ERR3");
        }catch (IOException screenShotError){
            screenShotError.printStackTrace();
        }
        test.fail("Failed");
        throw Aerr;
    }

}


    @After
    public void tearDown(){
        webDriver.quit();
    }
    @AfterClass
    public static void cleanUp(){
        report.flush();
    }

}
