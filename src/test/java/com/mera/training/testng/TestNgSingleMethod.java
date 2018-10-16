package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgSingleMethod {

    final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
    
    @BeforeMethod
    public void beforeMethod() {
        logger.debug("before each method");
    }

    @AfterMethod
    public void afterMethod() {
        logger.debug("after each method");
    }

    @Test
    public void testArea1Sc1() {
        logger.debug("testArea1Sc1");
    }
}
