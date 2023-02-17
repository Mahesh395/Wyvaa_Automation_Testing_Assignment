package Wyvaa.onemyle.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements OneMyleConstants {

	public WebDriver driver;
	PropertyUtils pUtil = new PropertyUtils();

	@BeforeSuite
	public void configBS() {
		// Configure the Before Suite
		// DB Connection
	}

	@BeforeTest
	public void configBT() {
		// Configure the Before Test
		// parallel testing codes
		// Any Pre-Conditions
	}

	@BeforeClass
	public void configBC() {

		// Launch The Browser
		// Navigate To URL
		String browserName = pUtil.getPropertyData(PROPFILE_PATH, BROWSER_NAME);
		String Url = pUtil.getPropertyData(PROPFILE_PATH, MAINURL);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new SessionNotCreatedException("browser is not compatible");
		}
		driver.manage().window().maximize();
		driver.get(Url);
	}

	@BeforeMethod
	public void configBM() {

		driver.manage().timeouts().implicitlyWait(OneMyleConstants.IMP_TIME, TimeUnit.SECONDS);
		//login to the application
	
	}

	@AfterMethod
	public void configAM(ITestResult result) throws Throwable {
		
		String testCaseName = result.getName();
		int testCaseStatus = result.getStatus();

		if (testCaseStatus == result.FAILURE) {
			String filepath = GetScreenshot.getWebImage(driver, testCaseName);
			System.out.println(filepath);
		}
		// logout from Application


	}

	@AfterClass
	public void configAC() {
		// Close the Browser
		driver.quit();
	}

	@AfterTest
	public void configAT() {
		// Configure the Before Test
		// parallel testing codes
		// Any Post-Conditions
	}

	@AfterSuite
	public void configAS() {
		// Configure the Before Suite
		// Close DB Connection
	}

}
