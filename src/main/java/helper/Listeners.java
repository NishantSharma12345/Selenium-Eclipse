package helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Utils implements ITestListener
{
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	ExtentTest test;
	WebDriver driver;
	
	//String screenShotDestination;
	//List<String> screenshotPath = new ArrayList<String>();
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
		
		//deleteScreenshot();
		
		/*if(!screenshotPath.isEmpty())
		{
			for(int i = 0; i <= screenshotPath.size(); i++)
			{
				deleteScreenshot(screenshotPath.get(i));
			}
		}*/
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());
		try
		{
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			//screenShotDestination = getScreenShotPath(result.getMethod().getMethodName(), driver);
			//screenshotPath.add(screenShotDestination);
			test.addScreenCaptureFromPath(getScreenshotPath(driver, result.getMethod().getMethodName()), result.getMethod().getMethodName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{
	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
