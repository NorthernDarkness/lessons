package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgAlwaysRun {

    final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
    
    @BeforeClass
    public void beforeClass() {
        logger.debug("before class");
        throw new SkipException("123");
    }

//    @AfterClass
    @AfterClass(groups ="area1", alwaysRun = true)
    public void afterClass() {
        logger.debug("after class");
    }

    @Test(groups = "area1")
    public void testArea1Sc1() {
        logger.debug("testArea1Sc1");
    }
}
