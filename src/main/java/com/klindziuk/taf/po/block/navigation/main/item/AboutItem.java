package com.klindziuk.taf.po.block.navigation.main.item;

import com.klindziuk.taf.common.envelope.LocatorPath;
import com.klindziuk.taf.common.language.LanguageManager;
import com.klindziuk.taf.po.block.navigation.top.item.Language;
import lombok.RequiredArgsConstructor;

/**
 * Represents parameters for 'About' dropdown
 */
@RequiredArgsConstructor
public enum AboutItem implements LocatorPath {

    BLOG("Blog", "Blog"),
    PRESS("Press", "Pers"),
    EVENTS("Events","Evenementen"),
    CONTACT_US("Contact us", "Contact");

    private final String eng;
    private final String nl;

    public String getText(){
        Language language = LanguageManager.getLanguage();
        switch (language) {
            case INTERNATIONAL: return eng;
            case NETHERLANDS: return nl;
            default: return eng;
        }
    }
}
