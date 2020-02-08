package com.klindziuk.taf.po.page;

import com.klindziuk.taf.common.util.JavaScriptUtil;

/**
 * Base page
 */
public abstract class BasePage {

    protected static final String DESKTOP_PARENT_ELEMENT = "//*[@id=\"hero-image-desktop\"]";

    public abstract boolean isPageOpened(int seconds);

    public void loadFooter() {
        JavaScriptUtil.scrollToBottom();
    }

    public void loadHeader() {
        JavaScriptUtil.scrollToTop();
    }
}
