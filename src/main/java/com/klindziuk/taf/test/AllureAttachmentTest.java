package com.klindziuk.taf.test;

import com.klindziuk.taf.common.config.Group;
import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.common.log.Info;
import com.klindziuk.taf.po.page.MainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllureAttachmentTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        mainPage = new MainPage();
    }

    @Test(groups = { Group.SMOKE })
    @Feature("Footer")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyAttachmentTest() {

        Info.step("Open Home page");
        mainPage.loadPage();
        Info.verify("Verify that 'Home page' is opened");
        Assert.assertTrue(mainPage.isPageOpened(TimeConstant.SECONDS_5), "'Home page' is not opened.");

        Info.step("'Scroll to footer'");
        mainPage.loadFooter();

        Info.verify("Fail test to verify attachments");
        Assert.fail("Fail test script to verify Allure attachments.");
    }
}
