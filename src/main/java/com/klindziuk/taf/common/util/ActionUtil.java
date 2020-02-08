package com.klindziuk.taf.common.util;

import com.klindziuk.taf.common.driver.DriverManager;
import com.klindziuk.taf.common.envelope.WebEnvelope;
import org.openqa.selenium.interactions.Actions;

/**
 * Utility for perform Web driver 'Actions'.
 */
public class ActionUtil {

    private ActionUtil() {
    }

    /**
     * Moves cursor to element
     *
     * @param we WebEnvelope instance
     */
    public static void moveCursorToElement(WebEnvelope we) {
        new Actions(DriverManager.getDriver()).moveToElement(we.getWebElement()).build().perform();
    }

    /**
     * Performs 'double click' on element
     *
     * @param we WebEnvelope instance
     */
    public static void doubleClickOnElement(WebEnvelope we) {
        new Actions(DriverManager.getDriver()).doubleClick(we.getWebElement()).build().perform();
    }

    /**
     * Performs 'context click' on element
     *
     * @param we WebEnvelope instance
     */
    public static void contextClickOnElement(WebEnvelope we) {
        new Actions(DriverManager.getDriver()).contextClick(we.getWebElement()).build().perform();
    }

    /**
     * Performs 'drag and drop' action
     *
     * @param from start point
     * @param to   destination
     */
    public static void dragAndDrop(WebEnvelope from, WebEnvelope to) {
        new Actions(DriverManager.getDriver()).dragAndDrop(from.getWebElement(), to.getWebElement()).build().perform();
    }
}
