package com.klindziuk.taf.common.driver.storage;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

/**
 * Storage for browser's capabilities
 */
final class CapabilityStorage {

    private CapabilityStorage() {
    }

    /**
     * Returns DesiredCapabilities for 'Chrome' browser
     */
    static DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName(BROWSER_NAME);
        capabilities.setCapability(ChromeOptions.CAPABILITY, OptionStorage.getChromeOptions());
        return capabilities;
    }

    /**
     * Returns DesiredCapabilities for 'FireFox' browser
     */
    static DesiredCapabilities getFireFoxCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName(BROWSER_NAME);
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, OptionStorage.getFireFoxOptions());
        return capabilities;
    }

    /**
     * Returns DesiredCapabilities for 'internet explorer' browser
     */
    static DesiredCapabilities getIeCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setBrowserName(BROWSER_NAME);
        return capabilities;
    }

    /**
     * Returns DesiredCapabilities for 'Safari' browser
     */
    static DesiredCapabilities getSafariCapabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        capabilities.setBrowserName(BROWSER_NAME);
        return capabilities;
    }
}
