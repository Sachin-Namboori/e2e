package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends Base implements ITestListener{
ExtentTest test;
	ExtentReports extent = ExtentReportdemo.getExtentObect();
	ThreadLocal<ExtentTest> extest = new ThreadLocal<ExtentTest>();
	
	
	
	
	public void onTestStart(ITestResult result) {

	
		test = extent.createTest(result.getMethod().getMethodName());

		extest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extest.get().pass("Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		
		test.fail("Test Failed");
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			extest.get().addScreenCaptureFromPath(getScreenshotcode(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			//getScreenshotcode(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
	extent.flush();
	}
	
	

}
