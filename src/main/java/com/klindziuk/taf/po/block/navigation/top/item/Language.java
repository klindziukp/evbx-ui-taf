package com.klindziuk.taf.po.block.navigation.top.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents parameters for 'Language' dropdown
 */
@RequiredArgsConstructor
public enum Language {

    NETHERLANDS("Netherlands"),
    FRANCE("France"),
    UK_IRELAND("UK & Ireland"),
    BELGIUM_FLEMISH("Belgium (Flemish)"),
    BELGIUM_FRENCH("Belgium (French)"),
    DACH_GERMAN("DACH (German)"),
    NORWAY("Norway"),
    SWEDEN("Sweden"),
    NORTH_AMERICA("North America"),
    SPAIN("Spain"),
    INTERNATIONAL("International");

    @Getter
    private final String name;
}
