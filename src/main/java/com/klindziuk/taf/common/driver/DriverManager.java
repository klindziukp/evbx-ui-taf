package com.klindziuk.taf.common.driver;

import org.openqa.selenium.WebDriver;

/**
 * Driver Manager
 */
public final class DriverManager {

    private DriverManager() {
    }

    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocalWebDriver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        threadLocalWebDriver.set(webDriver);
    }

    public static void removeWebDriver() {
        threadLocalWebDriver.remove();
    }
}
