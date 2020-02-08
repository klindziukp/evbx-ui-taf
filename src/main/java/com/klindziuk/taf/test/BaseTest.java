package com.klindziuk.taf.test;

import com.klindziuk.taf.po.block.navigation.Navigation;
import org.testng.asserts.SoftAssert;

public abstract class BaseTest {

    void verifyMenuItems(Navigation navigation) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navigation.mainNavMenu().isProductVisible(), "'Product' tab is not visible.");
        softAssert.assertTrue(navigation.mainNavMenu().isPartnersVisible(), "'Partners' tab is not visible.");
        softAssert.assertTrue(navigation.mainNavMenu().isAboutVisible(), "'About' tab is not visible.");
        softAssert.assertAll();
    }
}
