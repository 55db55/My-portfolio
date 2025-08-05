package utils;

import base.BaseFile;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();

        if (testClass instanceof BaseFile) {
            BaseFile baseFile = (BaseFile) testClass;
            if (baseFile.getDriver() != null) {
                ScreenshotHelper.takeFailureScreenshot(
                        baseFile.getDriver(),
                        result.getMethod().getMethodName());
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object testClass = result.getInstance();

        if (testClass instanceof BaseFile) {
            BaseFile baseFile = (BaseFile) testClass;
            if (baseFile.getDriver() != null) {
                ScreenshotHelper.takeSuccessScreenshot(
                        baseFile.getDriver(),
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