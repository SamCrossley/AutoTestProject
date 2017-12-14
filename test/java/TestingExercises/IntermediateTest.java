package TestingExercises;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class IntermediateTest {
	
	private WebDriver webDriver;
	private static ExtentReports report;
    private SpreadSheetReader reader = new SpreadSheetReader("C:\\Users\\Admin\\eclipse-workspace\\Project1\\TestExamples.xlsx");



	@BeforeClass
	public static void init() {
		report = new ExtentReports();
		String fileName = "NewReport" + ".html";
		String filePath = System.getProperty("user.dir")+File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	
	@Before
	public void setUp() {

        String browser = reader.readRow(1, "Sheet1").get(1);
        String browser2 = reader.readRow(2, "Sheet1").get(1);
	    webDriver = WebDriverFactory.getWebDriver(browser);

	}

	@Test
	public void Test() {
        String url = reader.readRow(1, "Sheet1").get(2);
        String username = reader.readRow(1, "Sheet1").get(3);
        String password = reader.readRow(1,"Sheet1").get(4);
        String pf = reader.readRow(1,"Sheet1").get(5);
        String url2 = reader.readRow(2, "Sheet1").get(2);
        String username2 = reader.readRow(2, "Sheet1").get(3);
        String password2 = reader.readRow(2,"Sheet1").get(4);
        String pf2 = reader.readRow(2,"Sheet1").get(5);
		ExtentTest test = report.createTest("MyFirstTest");
		test.log(Status.INFO, "My First Test is Starting ");
		webDriver.navigate().to(url);
		BannerPage bannerPage = PageFactory.initElements(webDriver, BannerPage.class);
		bannerPage.clickAddUser();
		
		AddUserPage addUserPage = PageFactory.initElements(webDriver, AddUserPage.class);
		test.log(Status.DEBUG, "Adding new username");
		addUserPage.pickUsername(username);
		test.log(Status.DEBUG, "Adding associated password");
		addUserPage.pickPassword(password);
		addUserPage.clickSave();
		
		addUserPage.clickLogin();
		LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		test.log(Status.DEBUG, "Entering added username");
		loginPage.enterUsername(username);
		test.log(Status.DEBUG, "Entering associated password");
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		try {
			Assert.assertEquals("Unsuccessful Login", pf, LoginPage.successfulBox.getText());
			test.pass("Passed");
		}catch (AssertionError Ae){
			/*String details = "Training.Example Failing test: " + Ae.getMessage();
			test.fail(details);
			Assert.fail(details);*/
			try {
			    ScreenShot screenShot = new ScreenShot();
				screenShot.take(webDriver, "loginError");
			} catch (IOException screenShotError) {
				screenShotError.printStackTrace();
			}
			test.fail("Failed");
			throw Ae;
		}
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException Ie) {
			// TODO Auto-generated catch block
			Ie.printStackTrace();
		}
		
		
		
	}
	@After
	public void tearDown() {
		webDriver.quit();
	}

	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
}
