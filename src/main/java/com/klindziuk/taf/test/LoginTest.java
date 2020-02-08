package com.klindziuk.taf.test;

import com.klindziuk.taf.common.config.Group;
import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.common.log.Info;
import com.klindziuk.taf.po.block.navigation.Navigation;
import com.klindziuk.taf.po.page.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private MainPage mainPage;
    private Navigation navigation;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        mainPage = new MainPage();
        navigation = new Navigation();
    }

    @Test(groups = { Group.SMOKE })
    @Feature("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {

        Info.step("Open Home page");
        mainPage.loadPage();
        Info.verify("Verify that 'Home page' is opened");
        Assert.assertTrue(mainPage.isPageOpened(TimeConstant.SECONDS_5), "'Home page' is not opened.");

        Info.step("'Log into different pages'");
        String login = "Evb-login";
        String pass = "Evb-password";
        navigation.topNavMenu().loginWithBackOfficeLogin(login, pass);
        navigation.topNavMenu().loginWithHeyEvBoxLogin(login, pass);
        navigation.topNavMenu().loginWithPartnerPortalLogin(login, pass);

        Info.verify("Verify that 'Home page' is opened");
        Assert.assertTrue(mainPage.isPageOpened(TimeConstant.SECONDS_5), "'Home page' is not opened.");
    }
}
