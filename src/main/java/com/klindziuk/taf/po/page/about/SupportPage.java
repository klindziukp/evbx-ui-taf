package com.klindziuk.taf.po.page.about;

import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;
import com.klindziuk.taf.po.page.BasePage;

/**
 * Represents 'Support' page
 */
public class SupportPage extends BasePage {

    // PO Elements
    private WebEnvelope title() {
        String locator = DESKTOP_PARENT_ELEMENT + "//*[@class=\"hero-content__title\"]";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    // PO Methods
    @Override
    public boolean isPageOpened(int seconds) {
       return title().isVisible(seconds);
    }
}
