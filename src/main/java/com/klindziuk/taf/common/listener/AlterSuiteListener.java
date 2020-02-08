package com.klindziuk.taf.common.listener;

import com.klindziuk.taf.common.config.Config;
import com.klindziuk.taf.common.config.ConfigStorage;
import com.klindziuk.taf.common.constant.Env;
import com.klindziuk.taf.common.log.Info;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Optional;

/**
 * Defines test execution on runtime
 */
public class AlterSuiteListener implements IAlterSuiteListener {

    @Override
    public void alter(List<XmlSuite> suites) {
        int count = getThreadCount();
        Info.info(String.format("Test Suite will be executed in '%d' thread(s)", count));
        if (count <= 0) {
            return;
        }
        for (XmlSuite suite : suites) {
            suite.setThreadCount(count);
        }
    }

    private int getThreadCount() {
        return System.getProperty("profileName").equalsIgnoreCase(Env.LOCAL.name()) ? getLocalThreadCount()
                : Runtime.getRuntime().availableProcessors();
    }

    private int getLocalThreadCount() {
        Config config = ConfigStorage.getConfig();
        return Optional.ofNullable(config.getThreadCount()).orElse(1);
    }
}
