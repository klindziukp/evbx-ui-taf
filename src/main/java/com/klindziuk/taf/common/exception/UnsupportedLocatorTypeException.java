package com.klindziuk.taf.common.exception;

/**
 * Custom exception for case when unsupported locator type used.
 */
public class UnsupportedLocatorTypeException extends RuntimeException {

    public UnsupportedLocatorTypeException(String message) {
        super(message);
    }

    public UnsupportedLocatorTypeException(String message, Throwable cause) {
        super(message, cause);
    }

}
