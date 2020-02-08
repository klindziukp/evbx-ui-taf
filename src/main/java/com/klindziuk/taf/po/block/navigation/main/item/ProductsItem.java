package com.klindziuk.taf.po.block.navigation.main.item;

import com.klindziuk.taf.common.envelope.LocatorPath;
import com.klindziuk.taf.common.language.LanguageManager;
import com.klindziuk.taf.po.block.navigation.top.item.Language;
import lombok.RequiredArgsConstructor;

/**
 * Represents parameters for 'Products' dropdown
 */
@RequiredArgsConstructor
public enum ProductsItem implements LocatorPath {

    HOME_CHARGES("Home chargers", "Thuislaadpalen"),
    BUSINESS_CHARGES("Business chargers","Zakelijke laadpale"),
    FAST_CHARGES("Fast chargers","Snelladers"),
    ULTRA_FAST_CHARGES("Ultra-fast chargers","Ultrasnelladers"),
    PUBLIC_CHARGES("Public chargers","Publieke laadpalen"),
    SMART_CHARGES("Smart charging","Smart charging");

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
