package MouseActions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class SliderTest {

    private WebDriver
    private static ExtentReports report;




    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        String fileName = "SliderTestReport" + ".html";
        String filePath = System.getProperty("user.dir")+ File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));

    }
    @Before
    public void setUp(){

    }
    @Test
    public void test1(){

    }
    @After
    public void tearDown(){

    }
    @AfterClass
    public static void cleanUp(){

    }
}
