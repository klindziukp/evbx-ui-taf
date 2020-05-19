package com.klindziuk.taf.common.language;

import com.klindziuk.taf.po.block.navigation.top.item.Language;

/**
 * Sets appropriate language according to ui selection
 */
public final class LanguageManager {

    private LanguageManager() {
    }

    private static ThreadLocal<Language> threadLocalLanguage = ThreadLocal.withInitial(() -> Language.INTERNATIONAL);

    /**
     * Returns appropriate language for current instance of Driver
     */
    public static Language getLanguage() {
        return threadLocalLanguage.get();
    }

    /**
     * Sets language for current instance of Driver
     *
     * @param language supported language
     */
    public static void setLanguage(Language language) {
        threadLocalLanguage.set(language);
    }

    /**
     * Removes language for current instance of Driver
     */
    public static void removeLanguage() {
        threadLocalLanguage.remove();
    }
}
