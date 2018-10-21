package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestNgBuiltInParameters {

    final static Logger logger = Logger.getLogger(TestNgBuiltInParameters.class);

    @Test(groups = {"area1"})
    public void testArea1Sc2() {
        logger.debug("testArea1Sc1");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc2(ITestContext context) {
        logger.debug("testArea1Sc2");
        logger.debug("Methods run:");
        context.getSuite().getAllMethods().forEach(t -> logger.debug(t.getMethodName()));
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger.debug("after method");
        logger.debug("The previous case success:" + result.isSuccess());
    }
}
