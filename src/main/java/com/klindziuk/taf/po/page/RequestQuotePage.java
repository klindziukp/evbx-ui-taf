package com.klindziuk.taf.po.page;

import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

/**
 * Represents 'RequestQuotePage' page
 */
public class RequestQuotePage extends BasePage {

    // PO Elements
    private WebEnvelope title() {
        String locator = "//*[@id=\"navigation\"]//*[contains(text(),'Request a free quote')]";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    // PO Methods
    @Override
    public boolean isPageOpened(int seconds) {
        return title().isVisible(seconds);
    }
}
