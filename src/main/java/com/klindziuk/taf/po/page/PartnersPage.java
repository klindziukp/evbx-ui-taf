package com.klindziuk.taf.po.page;

import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

/**
 * Represents 'Partners' page
 */
public class PartnersPage extends BasePage {

    // PO Elements
    private WebEnvelope title() {
        String locator = DESKTOP_PARENT_ELEMENT
                + "//*[contains(@class, 'hero-content__title') and text() = 'Thanks a million']]";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    // PO Methods
    @Override
    public boolean isPageOpened(int seconds) {
        return title().isVisible(seconds);
    }
}
