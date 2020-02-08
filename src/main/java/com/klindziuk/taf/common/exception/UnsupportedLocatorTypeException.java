package com.klindziuk.taf.common.exception;

public class UnsupportedLocatorTypeException extends RuntimeException {

    public UnsupportedLocatorTypeException(String message) {
        super(message);
    }

    public UnsupportedLocatorTypeException(String message, Throwable cause) {
        super(message, cause);
    }

}
