package TestNGListner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TestNGtest implements ITestListener{

	public void onFinish(ITestContext result) {
		System.out.println("******Test is finished  "+ result.getName());
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("******Test is failed  "+ result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("******Test is skipped  "+ result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("******Test is started  "+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("******Test is successfull  "+ result.getName());
		
	}

}
