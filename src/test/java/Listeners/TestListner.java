package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestListner implements ITestListener {
    WebDriver driver=null;

//    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("---------------Test started---------------"+result.getName());
    }

//    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("---------------Test skipped---------------"+result.getName());
    }

//    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("---------------Test success---------------"+result.getName());
    }

//    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("---------------Test failed---------------"+result.getName());
    }

//    @Override
    public void onFinish(ITestContext context) {
        System.out.println("---------------Test finished---------------"+context.getName());
    }
}
