package com.klindziuk.taf.po.block.navigation.top.item;

import com.klindziuk.taf.common.envelope.LocatorPath;
import com.klindziuk.taf.common.language.LanguageManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents parameters for 'Top navigation' menu
 */
@RequiredArgsConstructor
public enum TopNavItem implements LocatorPath {

    CAREERS("Careers", "VACATURES"),
    SUPPORT("Support", "SUPPORT"),
    LOG_IN("LOG IN", "LOGIN");

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
