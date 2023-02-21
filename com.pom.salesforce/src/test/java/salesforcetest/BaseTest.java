package salesforcetest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import contestutility.ExtentReportsUtility;
import contestutility.PropertiesUtility;
import contestutility.constant;
@Listeners(contestutility.TestEventListenersUtility.class)

public class BaseTest {
	static WebDriver driver = null;
	static WebDriverWait wait=null;
	static  Logger logger = null;
	protected static ExtentReportsUtility extentreport = ExtentReportsUtility.getInstance();

	
	@BeforeTest
	public  void setUpBeforeTest(){
		logger = LogManager.getLogger(BaseTest.class.getName());
		
		
	}

	

	public static void goToUrl(String url) {
		driver.get(url);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public static void refreshPage() {
		driver.navigate().refresh();

	}
	


public static void GetDriverInstance(String browserName) {


		switch (browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "chrome":
			WebDriverManager.chromedriver().setup();
			//ChromeOptions option=new ChromeOptions();
			//option.addArguments("--headless");
			//option.addArguments("--incognito");
			//option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.out.println("not entered proper browsername");
		}

	}
	
	
public   void   getScreenshotofThePage() {
	
String date = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
String curDir = System.getProperty("user.dir");
TakesScreenshot  screenShot =(TakesScreenshot )	driver;
File imgfile = screenShot.getScreenshotAs(OutputType.FILE);
File destFile = new File(constant.SCREENSHOTS_DIRECTORY_PATH+date+".png");
try {
	
	FileHandler.copy(imgfile, destFile);
}
catch(IOException e) {
	e.printStackTrace();
	
}

}
public String getScreenShotBase64(WebDriver driver) {
String date = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
String curDir = System.getProperty("user.dir");
TakesScreenshot  screenShot =(TakesScreenshot )	driver;
String img = screenShot.getScreenshotAs(OutputType.BASE64);


return img;


}

	

public WebDriver returnDriverInstance() {
	// TODO Auto-generated method stub
	return driver;
}


}
