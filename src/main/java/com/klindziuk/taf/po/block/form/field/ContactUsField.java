package com.klindziuk.taf.po.block.form.field;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents parameters for 'Contact Us' form fields
 */
@RequiredArgsConstructor
public enum ContactUsField {

    FIRST_NAME("firstname"),
    LAST_NAME("lastname"),
    EMAIL("email"),
    POSTAL_CODE("zip"),
    CITY("city"),
    COUNTRY("country"),
    MESSAGE("message");

    @Getter
    private final String name;
}
