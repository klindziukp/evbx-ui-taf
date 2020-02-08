package com.klindziuk.taf.common.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.klindziuk.taf.common.exception.YamlMappingException;

import java.io.File;
import java.io.IOException;

/**
 * Utility read yaml files.
 */
public final class YamlUtil {

    private static final String PARSING_ERROR_MESSAGE = "Parsing error: yaml structure doesn't match model.";
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper(new YAMLFactory())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.findAndRegisterModules();
    }

    private YamlUtil() {
    }

    /**
     * Returns object that represents file
     *
     * @param path     path to file
     * @param classOfT class to map object
     * @param <T>      generic type of class
     * @return instance of T
     */
    public static <T> T fromYaml(String path, Class<T> classOfT) {
        try {
            return mapper.readValue(new File(path), classOfT);
        } catch (IOException ex) {
            throw new YamlMappingException(PARSING_ERROR_MESSAGE, ex);
        }
    }
}
