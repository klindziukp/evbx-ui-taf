package com.klindziuk.taf.common.exception;

/**
 * Custom exception for case when unable to parse yaml file.
 */
public class YamlMappingException extends RuntimeException {

    public YamlMappingException(String message) {
        super(message);
    }

    public YamlMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
