package com.klindziuk.taf.po.block.navigation.top;

import com.klindziuk.taf.common.constant.XpathConstant;
import com.klindziuk.taf.common.language.LanguageManager;
import com.klindziuk.taf.common.log.Info;
import com.klindziuk.taf.common.util.JavaScriptUtil;
import com.klindziuk.taf.po.block.navigation.top.item.Language;
import com.klindziuk.taf.po.block.navigation.top.item.TopNavItem;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;
import com.klindziuk.taf.po.page.login.BackOfficeLogin;
import com.klindziuk.taf.po.page.login.HeyEvBoxLogin;
import com.klindziuk.taf.po.page.login.PartnerPortalLogin;

import java.util.Objects;

/**
 * Represents 'Top navigation menu' page
 */
public class TopNavMenu {

    private static final String PARENT_LOCATOR = "//*[@class=\"top-nav-wrapper\"]";

    private BackOfficeLogin backOfficeLogin;
    private HeyEvBoxLogin heyEvBoxLogin;
    private PartnerPortalLogin partnerPortalLogin;

    // PO Elements
    private WebEnvelope topNavBarItem(TopNavItem topNavItem) {
        String locator = PARENT_LOCATOR + XpathConstant.CONTAINS_TEXT;
        String namedLocator = String.format(locator, topNavItem.getText());
        return new WebEnvelope(LocatorType.XPATH, namedLocator);
    }

    private WebEnvelope languageButton() {
        String locator = PARENT_LOCATOR + "//*[button]";
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    private WebEnvelope language(Language language) {
        String locator = "//*[@class=\"language-switch-dropdown\"]" + XpathConstant.CONTAINS_TEXT;
        String namedLocator = String.format(locator, language.getName());
        return new WebEnvelope(LocatorType.XPATH, namedLocator);
    }

    // PO Methods
    public void loginWithBackOfficeLogin(String password, String username) {
        if (Objects.isNull(backOfficeLogin)) {
            this.backOfficeLogin = new BackOfficeLogin();
        }
        backOfficeLogin.login(password, username);
    }

    public void loginWithHeyEvBoxLogin(String password, String username) {
        if (Objects.isNull(heyEvBoxLogin)) {
            this.heyEvBoxLogin = new HeyEvBoxLogin();
        }
        heyEvBoxLogin.login(password, username);
    }

    public void loginWithPartnerPortalLogin(String password, String username) {
        if (Objects.isNull(partnerPortalLogin)) {
            this.partnerPortalLogin = new PartnerPortalLogin();
        }
        partnerPortalLogin.login(password, username);
    }

    public void openCareersPage() {
        topNavBarItem(TopNavItem.CAREERS).waitForVisible().click();
    }

    public void openSupportPage() {
        topNavBarItem(TopNavItem.SUPPORT).waitForVisible().click();
    }

    public TopNavMenu switchToLanguage(Language language) {
        Info.info("Switching language to: " + language);
        JavaScriptUtil.scrollPage(0, -10);
        languageButton().waitForVisible().click();
        language(language).waitForVisible().click();
        LanguageManager.setLanguage(language);
        return this;
    }
}
