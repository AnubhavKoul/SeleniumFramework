package Framework.NewProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporter;
import Resources.Setup;

public class Listeners extends Setup implements ITestListener {

	ExtentReports extent = ExtentReporter.getReportObject();
	ExtentTest test;
	
	// To make the test object thread safe so that in parallel execution it wont get overridden use ThreadLocal class  
	ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.createTest(result.getMethod().getMethodName());
		// A pool will be created which will save the names
		extentThread.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//extent report test object to log the success in the report.
		extentThread.get().log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//get getThrowable will retrieve the failed logs from result object.
		
		extentThread.get().fail(result.getThrowable());
		WebDriver driver = null;
		
		// Getting the name of the test which failed.		
		String failedTestMethodName = result.getMethod().getMethodName();
		
		/*Getting the driver of the test so that we will save a screenshot for the same
		test. As it should be the same driver for which the test has failed.*/
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//adding screen shot to the extent report.
			extentThread.get().addScreenCaptureFromPath(getScreenShot(failedTestMethodName, driver),result.getMethod().getMethodName());
			/*if dont want to add screenshot in extent report, comment the above line and just keep below
			 * and remove the return from the method getScreenShot and make return type as void
			getScreenShot(failedTestMethodName, driver);
			*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

}
