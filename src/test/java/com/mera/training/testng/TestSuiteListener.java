package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.testng.*;

import java.util.List;

public class TestSuiteListener implements ISuiteListener {

    final static Logger logger = Logger.getLogger(TestNgAllInitMethods.class);

    @Override
    public void onFinish(ISuite suite) {
        logger.debug("Finishing suite");
    }

    @Override
    public void onStart(ISuite suite) {
        logger.debug("Starting suite");
    }
}
