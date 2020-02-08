package com.klindziuk.taf.common.language;

import com.klindziuk.taf.po.block.navigation.top.item.Language;

/**
 * Sets appropriate language according to ui selection
 */
public final class LanguageManager {

    private LanguageManager() {
    }

    private static ThreadLocal<Language> threadLocalWebDriver = ThreadLocal.withInitial(() -> Language.INTERNATIONAL);

    public static Language getLanguage() {
        return threadLocalWebDriver.get();
    }

    public static void setLanguage(Language language) {
        threadLocalWebDriver.set(language);
    }

    public static void removeLanguage() {
        threadLocalWebDriver.remove();
    }
}
