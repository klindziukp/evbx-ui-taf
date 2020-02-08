package com.klindziuk.taf.common.util;

import com.klindziuk.taf.common.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Utility for perform JavaScript commands.
 */
public final class JavaScriptUtil {

    private JavaScriptUtil() {
    }

    /**
     * Returns page title
     *
     * @return window title
     */
    public static String getWindowTitle() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        return js.executeScript("return document.title;").toString();
    }

    /**
     * Scrolls page to appropriate coordinates
     *
     * @param x coordinate
     * @param y coordinate
     */
    public static void scrollPage(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(String.format("window.scrollBy(%d,%d)", x, y));
    }

    /**
     * Refreshes a page
     */
    public static void refresh() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("history.go(0)");
    }

    /**
     * Scrolls to bottom
     *
     */
    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Scrolls to top
     *
     */
    public static void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, 0)");
    }
}
