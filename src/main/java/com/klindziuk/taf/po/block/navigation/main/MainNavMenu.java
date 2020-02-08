package com.klindziuk.taf.po.block.navigation.main;

import com.klindziuk.taf.common.constant.TimeConstant;
import com.klindziuk.taf.common.util.ActionUtil;
import com.klindziuk.taf.po.block.navigation.main.item.MainNavItem;
import com.klindziuk.taf.po.block.submenu.AboutSubMenu;
import com.klindziuk.taf.po.block.submenu.ProductsSubMenu;
import com.klindziuk.taf.po.block.submenu.ResourcesSubMenu;
import com.klindziuk.taf.common.envelope.LocatorType;
import com.klindziuk.taf.common.envelope.WebEnvelope;

import java.util.Objects;

/**
 * Represents 'Main navigation menu' page
 */
public class MainNavMenu {

    private AboutSubMenu aboutSubMenu;
    private ProductsSubMenu productsSubMenu;
    private ResourcesSubMenu resourcesSubMenu;

    // PO Elements
    private WebEnvelope navBarItem(MainNavItem mainNavItem) {
        String locator = String.format("//*[@class=\"navigation-menu\"]//*[contains(text(),'%s')]",
                mainNavItem.getText());
        return new WebEnvelope(LocatorType.XPATH, locator);
    }

    // PO Methods
    public AboutSubMenu about() {
        WebEnvelope we = navBarItem(MainNavItem.ABOUT).waitForVisible();
        ActionUtil.moveCursorToElement(we);
        return getAboutSubMenu();
    }

    public ProductsSubMenu products() {
        WebEnvelope we = navBarItem(MainNavItem.PRODUCTS).waitForVisible();
        ActionUtil.moveCursorToElement(we);
        return getProductsSubMenu();
    }

    public ResourcesSubMenu openResources() {
        WebEnvelope we = navBarItem(MainNavItem.RESOURCES).waitForVisible();
        ActionUtil.moveCursorToElement(we);
        return getResourcesSubMenu();
    }

    public void openPartnersPage() {
        navBarItem(MainNavItem.PARTNERS).waitForVisible().click();
    }

    public void openRequestQuotePage() {
        navBarItem(MainNavItem.REQUEST_A_QUOTE).waitForVisible().click();
    }

    public boolean isProductVisible() {
        return navBarItem(MainNavItem.PRODUCTS).isVisible(TimeConstant.SECONDS_3);
    }

    public boolean isPartnersVisible() {
        return navBarItem(MainNavItem.PARTNERS).isVisible(TimeConstant.SECONDS_3);
    }

    public boolean isAboutVisible() {
        return navBarItem(MainNavItem.ABOUT).isVisible(TimeConstant.SECONDS_3);
    }

    private AboutSubMenu getAboutSubMenu() {
        if (Objects.isNull(aboutSubMenu)) {
            this.aboutSubMenu = new AboutSubMenu();
        }
        return aboutSubMenu;
    }

    private ProductsSubMenu getProductsSubMenu() {
        if (Objects.isNull(productsSubMenu)) {
            this.productsSubMenu = new ProductsSubMenu();
        }
        return productsSubMenu;
    }

    private ResourcesSubMenu getResourcesSubMenu() {
        if (Objects.isNull(resourcesSubMenu)) {
            this.resourcesSubMenu = new ResourcesSubMenu();
        }
        return resourcesSubMenu;
    }
}
