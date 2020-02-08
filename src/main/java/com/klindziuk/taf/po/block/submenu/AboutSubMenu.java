package com.klindziuk.taf.po.block.submenu;

import com.klindziuk.taf.po.block.navigation.main.item.AboutItem;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

/**
 * Represents 'About' sub menu
 */
public class AboutSubMenu extends BaseSubMenu {

    private WebEnvelope productsSubMenuItem(AboutItem aboutItem) {
        return new WebEnvelope(LocatorType.XPATH, String.format(SUB_MENU_ITEM_PATH, aboutItem.getText()));
    }

    public void openSubMenu(AboutItem aboutItem) {
        productsSubMenuItem(aboutItem).waitForVisible().click();
    }
}
