package contestutility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import salesforcetest.BaseTest;

public class TestEventListenersUtility implements ITestListener
{
	protected static ExtentReportsUtility extentreport=null;
	protected WebDriver driver;
	
	
	
@Override

	public void onTestStart(ITestResult result) {
		
		extentreport.startSingleTestReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentreport.logTestpassed(result.getMethod().getMethodName());
		BaseTest ob=new BaseTest();
		//driver=ob.returnDriverInstance();
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentreport.logTestFailed(result.getMethod().getMethodName());
		BaseTest ob=new BaseTest();
		driver=ob.returnDriverInstance();
		String path=ob.getScreenShotBase64(driver);
		//String path1 = ob.getScreenshotofThePage();
		extentreport.logTestScreenshot(path);
		extentreport.logTestFailedWithException(result.getThrowable());
		extentreport.logTestScreenshotBase64(path);
		
		
		
	} 
	
	
	
	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentreport=ExtentReportsUtility.getInstance();
		extentreport.startExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentreport.endReport();
	}

}