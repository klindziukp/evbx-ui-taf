package com.klindziuk.taf.common.listener;

import com.klindziuk.taf.common.driver.DriverFactory;
import com.klindziuk.taf.common.driver.DriverManager;
import com.klindziuk.taf.common.language.LanguageManager;
import com.klindziuk.taf.common.log.Info;
import com.klindziuk.taf.common.util.AllureUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

/**
 * Allows to perform actions 'before' and 'after' test methods
 */
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        instantiateWebDriver();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        printInfo(iTestResult, "SUCCESS");
        terminateWebDriver();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        printInfo(iTestResult, "FAILURE");
        AllureUtil.attachPageSource(DriverManager.getDriver());
        AllureUtil.attachScreenShot(DriverManager.getDriver());
        terminateWebDriver();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        printInfo(iTestResult, "SKIPPED");
        terminateWebDriver();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // Do nothing club
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // Do nothing club
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // Do nothing club
    }

    private void instantiateWebDriver() {
        WebDriver webDriver = DriverFactory.createWebDriverInstance();
        if (Objects.nonNull(webDriver)) {
            Info.info("Instantiating webDriver with hashcode: " + webDriver.hashCode());
            DriverManager.setDriver(webDriver);
        }
    }

    private void terminateWebDriver() {
        WebDriver webDriver = DriverManager.getDriver();
        if (Objects.nonNull(webDriver)) {
            Info.info("Terminating webDriver with hashcode: " + webDriver.hashCode());
            webDriver.quit();
        }
        LanguageManager.removeLanguage();
        DriverManager.removeWebDriver();
    }

    private void printInfo(ITestResult iTestResult, String result) {
        Info.info(String.format("=========%s============", result));
        Info.info(iTestResult.getMethod().getMethodName() + "()");
        Info.info("============================");
    }
}
