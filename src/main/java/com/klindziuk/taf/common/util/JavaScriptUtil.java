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
        executeJsCommand(String.format("window.scrollBy(%d,%d)", x, y));
    }

    /**
     * Refreshes a page
     */
    public static void refresh() {
        executeJsCommand("history.go(0)");
    }

    /**
     * Scrolls to bottom
     */
    public static void scrollToBottom() {
        executeJsCommand("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Scrolls to top
     */
    public static void scrollToTop() {
        executeJsCommand("window.scrollTo(0, 0)");
    }

    /**
     * Sends captcha token
     */
    public static void executeCaptchaToken(String token) {
        String tokenScript = String.format("$(\"#g-recaptcha-response\").val(\"%s\");", token);
        executeJsCommand(tokenScript);
    }

    /**
     * Execute post form
     */
    public static void sendPostForm() {
        executeJsCommand("$(\"form\")[0].submit();");
    }

    private static void executeJsCommand(String command) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(command);
    }
}
