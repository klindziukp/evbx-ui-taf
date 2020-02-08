package com.klindziuk.taf.common.util;

import java.io.File;

/**
 * Utility for perform actions with String class.
 */
public final class StringUtil {

    private StringUtil() {
    }

    /**
     * Makes string unique
     *
     * @param value string
     * @return unique string
     */
    public static String makeStringUnique(String value) {
        return value + System.currentTimeMillis();
    }

    /**
     * Updates slash symbol to platform independent
     *
     * @param path path of the file
     * @return updated path
     */
    public static String updatePath(String path) {
        return path.replace("/", File.separator);
    }
}
