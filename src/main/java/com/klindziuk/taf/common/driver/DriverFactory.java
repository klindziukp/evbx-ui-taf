package com.klindziuk.taf.common.driver;

import com.klindziuk.taf.common.config.ConfigStorage;
import com.klindziuk.taf.common.constant.BrowserConstant;
import com.klindziuk.taf.common.constant.Env;
import com.klindziuk.taf.common.driver.option.CapabilityStorage;
import com.klindziuk.taf.common.driver.option.OptionStorage;
import com.klindziuk.taf.common.exception.UnsupportedBrowserException;
import com.klindziuk.taf.common.log.Info;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Wed Driver factory
 */
public final class DriverFactory {

    private static final String BROWSER_NAME = System.getProperty("browserName");
    private static final String USER_DIR = System.getProperty("user.dir");

    private DriverFactory() {
    }

    /**
     * Returns Web driver instance
     *
     * @return Web driver instance
     */
    public static WebDriver createWebDriverInstance() {
        return createWebDriver();
    }

    private static WebDriver createWebDriver() {
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.CHROME)) {
            return getChromeWebDriver();
        }
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.FIREFOX)) {
            return getFireFoxWebDriver();
        }
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.SAFARI)) {
            return getSafariWebDriver();
        }
        if (BROWSER_NAME.equalsIgnoreCase(BrowserConstant.IE)) {
            return getIeWebDriver();
        }
        throw new UnsupportedBrowserException("Unsupported browser type: " + BROWSER_NAME);
    }

    private static WebDriver getChromeWebDriver() {
        if (isLocalProfile()) {
            String driverPath = String.join("", USER_DIR, ConfigStorage.getConfig().getChromePath());
            System.setProperty("webdriver.chrome.driver", driverPath);
            return new ChromeDriver(OptionStorage.getChromeOptions());
        }
        DesiredCapabilities capabilities = CapabilityStorage.getChromeCapabilities();
        return getRemoteDriver(capabilities);
    }

    private static WebDriver getFireFoxWebDriver() {
        if (isLocalProfile()) {
            String driverPath = String.join("", USER_DIR, ConfigStorage.getConfig().getFireFoxPath());
            System.setProperty("webdriver.firefox.driver", driverPath);
            return new FirefoxDriver();
        }
        DesiredCapabilities capabilities = CapabilityStorage.getFireFoxCapabilities();
        return getRemoteDriver(capabilities);
    }

    private static WebDriver getIeWebDriver() {
        if (isLocalProfile()) {
            String driverPath = String.join("", USER_DIR, ConfigStorage.getConfig().getIePath());
            System.setProperty("webdriver.ie.driver", driverPath);
            return new InternetExplorerDriver();
        }
        DesiredCapabilities capabilities = CapabilityStorage.getIeCapabilities();
        return getRemoteDriver(capabilities);
    }

    private static WebDriver getSafariWebDriver() {
        if (isLocalProfile()) {
            String driverPath = String.join("", USER_DIR, ConfigStorage.getConfig().getSafariPath());
            System.setProperty("webdriver.safari.driver", driverPath);
            return new SafariDriver();
        }
        DesiredCapabilities capabilities = CapabilityStorage.getSafariCapabilities();
        return getRemoteDriver(capabilities);
    }

    private static RemoteWebDriver getRemoteDriver(DesiredCapabilities desiredCapabilities) {
        return new RemoteWebDriver(getRemoteDriverUrl(), desiredCapabilities);
    }

    private static URL getRemoteDriverUrl() {
        URL remoteUrl = null;
        try {
            remoteUrl = new URL(ConfigStorage.getConfig().getRemoteDriverUrl());
        } catch (MalformedURLException mUrlEx) {
            Info.error(mUrlEx);
        }
        return remoteUrl;
    }

    private static boolean isLocalProfile() {
        return ConfigStorage.getConfig().getProfile().equalsIgnoreCase(Env.LOCAL.getName());
    }
}
