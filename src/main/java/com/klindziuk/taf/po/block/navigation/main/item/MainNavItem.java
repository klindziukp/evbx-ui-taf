package com.klindziuk.taf.po.block.navigation.main.item;

import com.klindziuk.taf.common.envelope.LocatorPath;
import com.klindziuk.taf.common.language.LanguageManager;
import com.klindziuk.taf.po.block.navigation.top.item.Language;
import lombok.RequiredArgsConstructor;

/**
 * Represents parameters for 'Main navigation' menu
 */
@RequiredArgsConstructor
public enum MainNavItem implements LocatorPath {

    PRODUCTS("Products", "Producten", "Produkter"),
    PARTNERS("Partners", "Partners", "Partnere"),
    ABOUT("About", "Over ons", "Om oss"),
    RESOURCES("Resources", "Over ons", "Ressurser"),
    REQUEST_A_QUOTE("Request a quote", "Offerte aanvragen", "Få et tilbud");

    private final String eng;
    private final String nl;
    private final String no;

    public String getText(){
        Language language = LanguageManager.getLanguage();
        switch (language) {
            case INTERNATIONAL: return eng;
            case NETHERLANDS: return nl;
            case NORWAY: return no;
            default: return eng;
        }
    }
}
