package MouseActions;

import TestingExercises.ScreenShot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SortableTest {

    private WebDriver webDriver;
    private static ExtentReports report;
    private Actions builder;
    private SortablePage page;

    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        String fileName = "SortableTestReport" + ".html";
        String filePath = System.getProperty("user.dir")+ File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));

    }
    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        builder = new Actions(webDriver);
        page = PageFactory.initElements(webDriver, SortablePage.class);

    }
    @Test
    public void defaultTest(){
        ExtentTest test = report.createTest("sortable Test 1");
        test.log(Status.INFO,"starting default sortable test");
        DefaultSort defaultSort = PageFactory.initElements(webDriver,DefaultSort.class);
        webDriver.navigate().to("http://demoqa.com/sortable/");
        Point point1 = defaultSort.item1.getLocation();

        Point point3 = defaultSort.item3.getLocation();

        int Y1 = point1.getY();
        int Y3 = point3.getY();
        int Ydiff1_3 = Y1 - Y3;
        webDriver.navigate().to("http://demoqa.com/sortable/");
        test.log(Status.DEBUG, "moving item3 to item1 position");
        builder.dragAndDropBy(defaultSort.item3,20,Ydiff1_3).perform();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Assert.assertEquals("Items not moved to correct positions", "Item 3", defaultSort.item1.getText());
            test.pass("Passed");
        }catch(AssertionError Aerr){
            try{              ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "defSort_ERR1");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }
    }
    @Test
    public void connectListTest(){
        ExtentTest test = report.createTest("connectListTest1");
        test.log(Status.INFO, "start of ");
        ConnectListSort connectListSort = PageFactory.initElements(webDriver, ConnectListSort.class);
        SortablePage sortablePage = PageFactory.initElements(webDriver, SortablePage.class);
        webDriver.navigate().to("http://demoqa.com/sortable/");
        sortablePage.clickConnectLists();
        Point point1_1 = connectListSort.item1_1.getLocation();
        Point point2_5 = connectListSort.item2_5.getLocation();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        int X2_5 = point2_5.getX();
        int Y2_5 = point2_5.getY();

       /* int Xdiff11_24 = X2_4 - X1_1 + 10 ;
        int Ydiff11_24 = Y2_4 - Y1_1 ;*/

        builder.clickAndHold(connectListSort.item1_1).release(connectListSort.item2_3).perform();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

/*
        Point point1_1f = connectListSort.item1_1.getLocation();
        int X1_1f = point1_1f.getX();
        int Y1_1f = point1_1f.getY();
*/

/*        boolean pass =false;
        if(X2_5 == X1_1f && Y2_5 == Y1_1f){
            pass = true;
        }*/
        try {
            Assert.assertEquals("Items not moved to correct positions", "Item 1", connectListSort.item2_4.getText());
            test.pass("Passed");
        }catch(AssertionError Aerr){
            try{              ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "connListSort_ERR1");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }
    }
    @Test
    public void gridDisplayTest(){
        ExtentTest test = report.createTest("gridDisplayTest");
        test.log(Status.INFO, "Starting gridDisplayTest");
        GridDisplaySort gridDisplaySort = PageFactory.initElements(webDriver, GridDisplaySort.class);
        SortablePage page = PageFactory.initElements(webDriver, SortablePage.class);
        webDriver.navigate().to("http://demoqa.com/sortable/");
        page.clickGridDisplay();

        Point point1 = gridDisplaySort.item1.getLocation();
        Point point6 = gridDisplaySort.item6.getLocation();

        int X1 = point1.getX();
        int Y1 =point1.getY();

        int X6 = point6.getX();
        int Y6 = point6.getY();

        int Ydiff = Y6-Y1 + 10;
        int Xdiff = X6 - X1 + 10;
        builder.clickAndHold(gridDisplaySort.item1).moveByOffset(Xdiff, Ydiff).release().perform();






        try {
            Assert.assertEquals("item not moved to position '6'", "1", gridDisplaySort.item6.getText());
            test.pass("Passed");
        }catch(AssertionError Aerr){
            try{
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "gridSort_ERR1");
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
