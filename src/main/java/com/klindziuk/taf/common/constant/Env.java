package com.klindziuk.taf.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents application environments
 */
@RequiredArgsConstructor
public enum Env {

    PROD("prod"),
    DEV("dev"),
    QA("qa"),
    LOCAL("local");

    @Getter
    private final String name;
}