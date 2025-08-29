package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Log;
import utils.ScreenshotHelper;

public class AllureScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();

        if (testClass instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testClass;
            if (baseTest.getDriver() != null) {
                ScreenshotHelper.takeFailureScreenshot(
                        baseTest.getDriver(),
                        result.getMethod().getMethodName());
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object testClass = result.getInstance();

        if (testClass instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testClass;
            if (baseTest.getDriver() != null) {
                ScreenshotHelper.takeSuccessScreenshot(
                        baseTest.getDriver(),
                        result.getMethod().getMethodName());
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.warn("Test skipped: " + result.getMethod().getMethodName());
    }
}