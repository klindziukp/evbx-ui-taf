package com.klindziuk.taf.po.page;

import com.klindziuk.taf.common.config.ConfigStorage;
import com.klindziuk.taf.common.driver.DriverManager;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

/**
 * Represents 'Main' page
 */
public class MainPage extends BasePage {

    // PO ELEMENTS
    private WebEnvelope logo() {
        String locator = "//*[@class=\"logo\"]";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    private WebEnvelope acceptButton(){
        return new WebEnvelope(LocatorType.ID, "hs-eu-confirmation-button");
    }

    // PO Methods
    @Override
    public boolean isPageOpened(int seconds) {
        return logo().isVisible(seconds);
    }

    public void loadPage() {
        DriverManager.getDriver().navigate().to(ConfigStorage.getConfig().getAppUrl());
        acceptButton().waitForVisible().click();
    }
}
