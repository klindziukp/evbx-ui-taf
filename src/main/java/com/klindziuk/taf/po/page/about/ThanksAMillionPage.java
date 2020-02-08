package com.klindziuk.taf.po.page.about;

import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;
import com.klindziuk.taf.po.page.BasePage;

/**
 * Represents 'Tanks a million' page
 */
public class ThanksAMillionPage extends BasePage {

    // PO Elements
    private WebEnvelope title() {
        String locator = DESKTOP_PARENT_ELEMENT
                + "//*[contains(@class, 'hero-content__title') and text() = 'Thanks a million']";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    // PO Methods
    @Override
    public boolean isPageOpened(int seconds) {
        return title().isVisible(seconds);
    }
}
