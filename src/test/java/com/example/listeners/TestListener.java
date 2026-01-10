package com.example.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.example.utils.ExtentManager;
import com.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentManager.createTest(testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        try {
            java.lang.reflect.Field f = instance.getClass().getDeclaredField("driver");
            f.setAccessible(true);
            WebDriver driver = (WebDriver) f.get(instance);
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            ExtentManager.getTest().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            Reporter.log("Screenshot saved to: " + path);
        } catch (Exception e) {
            ExtentManager.getTest().fail("Unable to capture screenshot: " + e.getMessage());
            Reporter.log("Unable to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().skip("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReports();
    }
}
