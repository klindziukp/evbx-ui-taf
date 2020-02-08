package com.klindziuk.taf.common.exception;

public class YamlMappingException extends RuntimeException {

    public YamlMappingException(String message) {
        super(message);
    }

    public YamlMappingException(String message, Throwable cause) {
        super(message, cause);
    }

}
