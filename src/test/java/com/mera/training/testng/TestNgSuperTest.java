package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgSuperTest {

    final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
    
    @BeforeMethod
    public void beforeMethod() {
        logger.debug("before each method super");
    }

    @BeforeGroups(groups = "area1")
    public void beforeGroup() {
        logger.debug("before each area1 group super");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc1() {
        logger.debug("testArea1Sc1");
    }


}
