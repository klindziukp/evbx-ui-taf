package com.klindziuk.taf.common.util;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.util.Objects;

/**
 * Utility for Allure report customization.
 */
public final class AllureUtil {

    private AllureUtil() {
    }

    /**
     * Attaches 'Page source' to Allure report
     *
     * @param webDriver instance of Web driver
     */
    public static void attachPageSource(WebDriver webDriver) {
        if (Objects.nonNull(webDriver)) {
            Allure.addAttachment("Page source", "text/xml", webDriver.getPageSource(), ".txt");
        }
    }

    /**
     * Attaches 'Page source' to Allure report
     *
     * @param webDriver instance of Web driver
     */
    public static void attachScreenShot(WebDriver webDriver) {
        if (Objects.nonNull(webDriver)) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("ScreenShot", "image/png", new ByteArrayInputStream(screenshot), ".png");
        }
    }
}
