package com.klindziuk.taf.test;

import com.klindziuk.taf.common.config.Group;
import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.common.log.Info;
import com.klindziuk.taf.po.block.footer.Footer;
import com.klindziuk.taf.po.block.navigation.Navigation;
import com.klindziuk.taf.po.page.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FooterTest extends BaseTest {

    private MainPage mainPage;
    private Navigation navigation;
    private Footer footer;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        mainPage = new MainPage();
        navigation = new Navigation();
        footer = new Footer();
    }

    @Test(groups = { Group.SMOKE })
    @Feature("Footer")
    @Severity(SeverityLevel.CRITICAL)
    public void footerTest() {

        Info.step("Open Home page");
        mainPage.loadPage();
        Info.verify("Verify that 'Home page' is opened");
        Assert.assertTrue(mainPage.isPageOpened(TimeConstant.SECONDS_5), "'Home page' is not opened.");

        Info.step("'Scroll to footer'");
        mainPage.loadFooter();

        Info.verify("Verify footer elements");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(footer.isTwitterVisible(), "'Twitter' icon is not visible.");
        softAssert.assertTrue(footer.isLinkedInVisible(), "'Linked' icon is not visible.");
        softAssert.assertTrue(footer.isFacebookVisible(), "'Facebook' icon is not visible.");

        Info.step("'Scroll to footer'");
        mainPage.loadHeader();
        verifyMenuItems(navigation);
    }
}
