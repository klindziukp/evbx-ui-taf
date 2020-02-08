package com.klindziuk.taf.common.envelope;

import java.util.List;

/**
 * Interface for wrappers: 'WebElement', 'MobileElement' and etc
 */
public interface Envelope {

    boolean isVisible();
    boolean isVisible(int timeout);
    Envelope waitForVisible();
    void waitForNotVisible();
    String getText();
    <T> List<T> getElementList();
}
