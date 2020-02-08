package com.klindziuk.taf.po.block.navigation;

import com.klindziuk.taf.po.block.navigation.main.MainNavMenu;
import com.klindziuk.taf.po.block.navigation.top.TopNavMenu;

import java.util.Objects;

/**
 * Represents 'Navigation Header' element
 */
public class Navigation {

    private TopNavMenu topNavMenu;
    private MainNavMenu mainNavMenu;

    public TopNavMenu topNavMenu() {
        return getTopNavMenu();
    }

    public MainNavMenu mainNavMenu() {
        return getMainNavMenu();
    }

    private TopNavMenu getTopNavMenu() {
        if (Objects.isNull(topNavMenu)) {
            this.topNavMenu = new TopNavMenu();
        }
        return topNavMenu;
    }

    private MainNavMenu getMainNavMenu() {
        if (Objects.isNull(mainNavMenu)) {
            this.mainNavMenu = new MainNavMenu();
        }
        return mainNavMenu;
    }
}
