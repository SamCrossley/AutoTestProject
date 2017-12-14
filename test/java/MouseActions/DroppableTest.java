package MouseActions;

import TestingExercises.ScreenShot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;


import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class DroppableTest {

    private WebDriver webDriver;
    private Actions builder;
    private static ExtentReports report;
    private DroppablePage page;

    @BeforeClass
    public static void init(){
    report = new ExtentReports();
    String fileName = "DroppableReport" + ".html";
    String filePath = System.getProperty("user.dir")+ File.separatorChar + fileName;
    report.attachReporter(new ExtentHtmlReporter(filePath));

    }
    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        builder = new Actions(webDriver);
        page = PageFactory.initElements(webDriver, DroppablePage.class);

    }
    @Test
    public void defaultTest(){
        ExtentTest test = report.createTest("defaultTest");
        test.log(Status.INFO, "Starting Default Drop Test");

        webDriver.navigate().to("http://demoqa.com/droppable/");
        DefaultFunctionalityDrop defaultDrop = PageFactory.initElements(webDriver, DefaultFunctionalityDrop.class);
        test.log(Status.DEBUG, "Dragging and Dropping Box");
        builder.dragAndDrop(defaultDrop.dragBox, defaultDrop.dropBox).perform();

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Assert.assertEquals("Drag and Drop failed", "Dropped!", defaultDrop.dropBox.getText());
            test.pass("Passed");
        }catch (AssertionError Aerr) {

            try {
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "NoDrop_ERR");
            } catch (IOException screenShotError) {
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }
    }

    @Test
    public void acceptTest1(){
        ExtentTest test = report.createTest("acceptTest");
        test.log(Status.INFO, "starting Accept Drop test" );
        webDriver.navigate().to("http://demoqa.com/droppable/");
        AcceptDrop acceptDrop = PageFactory.initElements(webDriver, AcceptDrop.class);
        test.log(Status.DEBUG, "switching to accept mode");
        page.clickAccept();
        test.log(Status.DEBUG, "dragging droppable box");
        builder.dragAndDrop(acceptDrop.dragAndDrop, acceptDrop.dropBox).perform();
        try {
            Assert.assertEquals("Drag and Drop failed", "Dropped!", acceptDrop.dropBox.getText());
            test.pass("Passed");
        }catch (AssertionError Aerr) {

            try {
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "Accept_ERR");
            } catch (IOException screenShotError) {
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }


    }
    @Test
    public void acceptTest2(){
        ExtentTest test = report.createTest("acceptTest");
        test.log(Status.INFO, "starting Accept Drop test 2" );
        webDriver.navigate().to("http://demoqa.com/droppable/");
        AcceptDrop acceptDrop = PageFactory.initElements(webDriver, AcceptDrop.class);

        test.log(Status.DEBUG, "switching to accept mode");
        page.clickAccept();

        test.log(Status.DEBUG,"dragging non-droppable box");
        builder.dragAndDrop(acceptDrop.dragNotDrop, acceptDrop.dropBox).perform();


        System.out.println(acceptDrop.dropBox.getText());
        try{
            Assert.assertEquals("Drag and non-drop failed", "accept: ‘#draggableaccept’",acceptDrop.dropBox.getText());
            test.pass("Passed");
        }catch(AssertionError Aerr){
            try{
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "Accept_ERR2");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }
    }
   @Test
   public void preventPropagationTest1(){
        ExtentTest test = report.createTest("preventPropagationTest");
        test.log(Status.INFO, "starting prevent Propagation Test1");
        webDriver.navigate().to("http://demoqa.com/droppable/");
        PreventPropagationDrop pP = PageFactory.initElements(webDriver, PreventPropagationDrop.class);
        test.log(Status.DEBUG,"switching to prevent propagation");
        page.clickPP();
        test.log(Status.DEBUG,"dragging droppable to not greedy inner");
        builder.dragAndDrop(pP.draggable,pP.notGreedyInner).perform();
        try{
            Assert.assertEquals("non-greedy behaving greedily", "Dropped!", pP.notGreedyOuter.getText());
            test.pass("Passed");
        }catch (AssertionError Aerr){
            try{
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "PP_ERR2");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }

    }
    @Test
    public void preventPropagationTest2(){
        ExtentTest test = report.createTest("preventPropagationTest2");
        test.log(Status.INFO, "starting prevent Propagation Test2");
        webDriver.navigate().to("http://demoqa.com/droppable/");
        PreventPropagationDrop pP = PageFactory.initElements(webDriver, PreventPropagationDrop.class);
        test.log(Status.DEBUG,"switching to prevent propagation");
        page.clickPP();
        test.log(Status.DEBUG,"dragging droppable to greedy inner");
        builder.dragAndDrop(pP.draggable,pP.greedyInner).perform();
        try{
            Assert.assertEquals("greedy behaving non-greedily", "Outer droppable", pP.greedyOuter.getText());
            test.pass("Passed");
        }catch (AssertionError Aerr){
            try{
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "PP_ERR2");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }

    }


    @Test
    public void revertDPTest1(){
        ExtentTest test = report.createTest("revertDraggablePositionTest1");
        test.log(Status.INFO, "starting Revert Draggable Position Test1");
        webDriver.navigate().to("http://demoqa.com/droppable/");
        RevertDraggablePositionDrop rDP = PageFactory.initElements(webDriver, RevertDraggablePositionDrop.class);
        test.log(Status.DEBUG,"switching to revert draggable position");
        page.clickRevertDP();
        Point point1 = rDP.revertWhenDropped.getLocation();
        test.log(Status.DEBUG,"dragging revert when dropped to dropBox");
        builder.dragAndDrop(rDP.revertWhenDropped, rDP.dropBox).perform();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Point point2 = rDP.revertWhenDropped.getLocation();
        try{
            Assert.assertEquals("Location doesn't match original", point1, point2);
            test.pass("Passed");
        }catch (AssertionError Aerr){
            try{
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "RDP_ERR1");
            }catch (IOException screenShotError){
                screenShotError.printStackTrace();
            }
            test.fail("Failed");
            throw Aerr;
        }




    }
    @Test
    public void revertDPTest2(){
        ExtentTest test = report.createTest("revertDraggablePositionTest1");
        test.log(Status.INFO, "starting Revert Draggable Position Test1");
        webDriver.navigate().to("http://demoqa.com/droppable/");
        RevertDraggablePositionDrop rDP = PageFactory.initElements(webDriver, RevertDraggablePositionDrop.class);
        test.log(Status.DEBUG,"switching to revert draggable position");
        page.clickRevertDP();
        test.log(Status.DEBUG,"dragging revert when not dropped to dropBox");
        Point point1 = rDP.revertWhenNotDropped.getLocation();
        builder.dragAndDrop(rDP.revertWhenNotDropped, rDP.dropBox).perform();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Point point2 = rDP.revertWhenNotDropped.getLocation();

        test.log(Status.DEBUG,"dragging revert when not dropped back to origin");
        builder.dragAndDrop(rDP.revertWhenNotDropped,rDP.revertWhenDropped);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Point point3 = rDP.revertWhenNotDropped.getLocation();
        try{
            Assert.assertEquals("Location doesn't match dropBox", point2, point3);
            test.pass("Passed");
        }catch (AssertionError Aerr){
            try{
                ScreenShot screenShot = new ScreenShot();
                screenShot.take(webDriver, "RDP_ERR2");
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
