package com.klindziuk.taf.common.driver.storage;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Storage for options
 */
public final class OptionStorage {

    private OptionStorage() {
    }

    /**
     * Returns options for 'Chrome' browser
     *
     * @return Chrome options
     */
    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--kiosk");
        chromeOptions.addArguments("--enable-javascript");
        chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        return chromeOptions;
    }

    /**
     * Returns options for 'FireFox' browser
     *
     * @return FireFox options
     */
    public static FirefoxOptions getFireFoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--disable-popup-blockings");
        return firefoxOptions;
    }
}
