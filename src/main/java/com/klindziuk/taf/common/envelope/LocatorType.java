package com.klindziuk.taf.common.envelope;

import com.klindziuk.taf.common.exception.UnsupportedLocatorTypeException;
import org.openqa.selenium.By;

/**
 *  Represents type of locators
 */
public enum LocatorType {

    ID, XPATH, CSS, CLASS_NAME, TAG_NAME, LINK_TEXT, PARTIAL_LINK_TEXT;

    public static By getBy(LocatorType locatorType, String locatorValue) {
        switch (locatorType) {
            case ID: return new By.ById(locatorValue);
            case XPATH: return new By.ByXPath(locatorValue);
            case CSS: return new By.ByCssSelector(locatorValue);
            case CLASS_NAME: return new By.ByClassName(locatorValue);
            case TAG_NAME: return new By.ByTagName(locatorValue);
            case LINK_TEXT: return new By.ByLinkText(locatorValue);
            case PARTIAL_LINK_TEXT: return new By.ByPartialLinkText(locatorValue);
        }
        throw new UnsupportedLocatorTypeException("Unsupported locator type" + locatorType.name());
    }
}
