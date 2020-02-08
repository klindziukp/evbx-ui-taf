package com.klindziuk.taf.po.block.form;

import com.klindziuk.taf.common.util.JavaScriptUtil;
import com.klindziuk.taf.po.block.form.field.ContactUsField;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

/**
 * Represents 'Contact Us' form
 */
public class ContactUsForm {

    // PO ELEMENTS
    private WebEnvelope contactUsItem(ContactUsField contactUsField) {
        String locator = String.format("//*[@name=\"%s\"]",contactUsField.getName());
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    private WebEnvelope country(String countryName) {
        String locator = String.format("//option[@value='%s']", countryName);
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    private WebEnvelope sendButton() {
        return new WebEnvelope(LocatorType.XPATH, "//*[@value=\"Send\"]");
    }

    // PO METHODS
    public ContactUsForm fillEmail(String email){
        contactUsItem(ContactUsField.EMAIL).waitForVisible().sendText(email);
        scrollDownABit();
        return this;
    }

    public ContactUsForm fillMessage(String message){
        contactUsItem(ContactUsField.MESSAGE).waitForVisible().sendText(message);
        scrollDownABit();
        return this;
    }

    public ContactUsForm fillName(String firstName, String lastName) {
        contactUsItem(ContactUsField.FIRST_NAME).waitForVisible().sendText(firstName);
        contactUsItem(ContactUsField.LAST_NAME).waitForVisible().sendText(lastName);
        scrollDownABit();
        return this;
    }

    public ContactUsForm fillPostalInfo(String postalCode, String city, String country){
        contactUsItem(ContactUsField.POSTAL_CODE).waitForVisible().sendText(postalCode);
        contactUsItem(ContactUsField.CITY).waitForVisible().sendText(city);
        selectCountry(country);
        scrollDownABit();
        return this;
    }

    public void submitForm(){
        sendButton().waitForVisible().click();
    }

    private void scrollDownABit(){
        JavaScriptUtil.scrollPage(0,400);
    }

    private void selectCountry(String countryName) {
        contactUsItem(ContactUsField.COUNTRY).waitForVisible().click();
        country(countryName).waitForVisible().click();
    }
}
