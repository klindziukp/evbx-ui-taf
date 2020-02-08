package com.klindziuk.taf.common.listener;

import com.klindziuk.taf.common.log.Info;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Allows to perform actions 'before' and 'after' suite methods
 */
public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        Info.info(iSuite.getName() + " - started.");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        Info.info(iSuite.getName() + " - finished.");
    }
}
