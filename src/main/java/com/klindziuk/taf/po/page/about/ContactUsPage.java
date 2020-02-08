package com.klindziuk.taf.po.page.about;

import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.po.block.form.ContactUsForm;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;
import com.klindziuk.taf.po.page.BasePage;

/**
 * Represents 'ContactUs' page
 */
public class ContactUsPage extends BasePage {

    private ContactUsForm contactUsForm;

    // PO Elements
    private WebEnvelope title() {
        String locator = DESKTOP_PARENT_ELEMENT + "//*[@class=\"hero-content__title\"]";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    private WebEnvelope requestHelpButton() {
        String locator = DESKTOP_PARENT_ELEMENT + "//*[@class=\"button button__primary\"]";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    // PO Constructor
    public ContactUsPage() {
        this.contactUsForm = new ContactUsForm();
    }

    // PO Methods
    public ContactUsForm contactUsForm(){
        return contactUsForm;
    }

    @Override
    public boolean isPageOpened(int seconds) {
       return title().isVisible(seconds);
    }

    public void openSupportPage(){
        requestHelpButton().waitForVisible().click();
    }

    public boolean isTitleVisible(){
        return title().isVisible(TimeConstant.SECONDS_3);
    }

    public boolean isRequestHelpButtonVisible(){
        return requestHelpButton().isVisible(TimeConstant.SECONDS_3);
    }
}
