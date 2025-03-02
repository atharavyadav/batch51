package listneres;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import seleniumActions.seleniumUIActions;

public class SeleniumListneres implements  ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("Execution started for the test case"+ result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
//		try {
//			seleniumUIActions.takescreenshot(result.getName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    ITestListener.super.onTestFailure(result);
	    try {
	        // Get the current date
	        String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

	        // Get the class and method names
	        String className = result.getTestClass().getName();
	        String methodName = result.getName();

	        // Create the directory structure
	        String directoryPath = "screenshots/" + date + "/" + className + "/" + methodName;
	        java.nio.file.Path path = java.nio.file.Paths.get(directoryPath);
	        java.nio.file.Files.createDirectories(path);

	        // Take the screenshot and save it in the created directory
	        seleniumUIActions.takescreenshot(directoryPath + "/" + methodName + ".png");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		System.out.println("end");
	}


}
