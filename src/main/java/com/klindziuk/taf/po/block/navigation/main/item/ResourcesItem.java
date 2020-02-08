package com.klindziuk.taf.po.block.navigation.main.item;

import com.klindziuk.taf.common.envelope.LocatorPath;
import com.klindziuk.taf.common.language.LanguageManager;
import com.klindziuk.taf.po.block.navigation.top.item.Language;
import lombok.RequiredArgsConstructor;

/**
 * Represents parameters for 'Resources' dropdown
 */
@RequiredArgsConstructor
public enum ResourcesItem implements LocatorPath {

    FAQS("FAQS", "FAQ"),
    BUSINESS_CHARGES("Electric cars", "Elektrische auto's"),
    FAST_CHARGES("Electric drivers", "Thuis laden"),
    ULTRA_FAST_CHARGES("Success stories", "Casestudies");

    private final String eng;
    private final String nl;

    public String getText() {
        Language language = LanguageManager.getLanguage();
        switch (language) {
            case INTERNATIONAL: return eng;
            case NETHERLANDS: return nl;
            default: return eng;
        }
    }
}