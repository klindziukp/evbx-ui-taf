package com.klindziuk.taf.common.driver;

import com.klindziuk.taf.common.constant.BrowserConstant;
import com.klindziuk.taf.common.driver.storage.DriverStorage;
import com.klindziuk.taf.common.exception.UnsupportedBrowserException;
import org.openqa.selenium.WebDriver;

/**
 * Wed Driver factory
 */
public final class DriverFactory {

    private static final String BROWSER_NAME = System.getProperty("browserName");

    private DriverFactory() {
    }

    /**
     * Returns Web driver instance
     */
    public static WebDriver createWebDriverInstance() {
        return createWebDriver();
    }

    private static WebDriver createWebDriver() {
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.CHROME)) {
            return DriverStorage.getChromeWebDriver();
        }
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.FIREFOX)) {
            return DriverStorage.getFireFoxWebDriver();
        }
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.SAFARI)) {
            return DriverStorage.getSafariWebDriver();
        }
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.IE)) {
            return DriverStorage.getIeWebDriver();
        }
        throw new UnsupportedBrowserException("Unsupported browser type: " + BROWSER_NAME);
    }
}
