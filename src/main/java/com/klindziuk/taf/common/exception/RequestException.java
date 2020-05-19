package com.klindziuk.taf.common.exception;

/**
 * Custom exception for case when cannot execute HTTP Request item.
 */
public class RequestException extends RuntimeException {

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
