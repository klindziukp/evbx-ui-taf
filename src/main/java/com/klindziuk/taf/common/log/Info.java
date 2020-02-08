package com.klindziuk.taf.common.log;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  Wrapper for logger
 */
public final class Info {

    private static final String ARROW = " -->";
    private static final String STEP = "Step: ";
    private static final String VERIFY = "Verification: ";
    private static final String ERROR = "ERROR";
    private static final String MULTI_DOTS = "...";
    private static Logger logger = LogManager.getLogger();

    private Info() {
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void verify(String message) {
        String stepMessage = String.join("", VERIFY, message, MULTI_DOTS);
        Allure.step(stepMessage);
        logger.info(stepMessage);
    }

    public static void step(String message) {
        String stepMessage = String.join("", STEP, message, ARROW);
        Allure.step(stepMessage);
        logger.info(stepMessage);
    }

    public static void error(Throwable throwable) {
        logger.error(ERROR, throwable);
    }
}
