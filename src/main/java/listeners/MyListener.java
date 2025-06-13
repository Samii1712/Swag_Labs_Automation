package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import pages.CheckoutPage;

public class MyListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		CheckoutPage.confirmOrderbyscreenshot();
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		CheckoutPage.confirmOrderbyscreenshot();
	}
}
