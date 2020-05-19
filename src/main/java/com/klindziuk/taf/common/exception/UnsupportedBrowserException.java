package com.klindziuk.taf.common.exception;

/**
 * Custom exception for case when unsupported browser used.
 */
public class UnsupportedBrowserException extends RuntimeException {

    public UnsupportedBrowserException(String message) {
        super(message);
    }

    public UnsupportedBrowserException(String message, Throwable cause) {
        super(message, cause);
    }
}
