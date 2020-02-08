package com.klindziuk.taf.po.block.submenu;

import com.klindziuk.taf.po.block.navigation.main.item.ProductsItem;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

/**
 * Represents 'Products' sub menu
 */
public class ProductsSubMenu extends BaseSubMenu {

    private WebEnvelope productsSubMenuItem(ProductsItem productsItem) {
        return new WebEnvelope(LocatorType.XPATH, String.format(SUB_MENU_ITEM_PATH, productsItem.getText()));
    }

    public void openSubMenu(ProductsItem productsItem) {
        productsSubMenuItem(productsItem).waitForVisible().click();
    }
}
