package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

import static org.testng.Assert.fail;

public class TestNgTest2Groups {

    final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
    
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        logger.debug("before each method for area1 group");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        logger.debug("after each method for area1 group");
    }

    @BeforeGroups(groups = "area1")
    public void beforeGroup() {
        logger.debug("before each area1 group");
    }

    @AfterGroups(groups = "area1")
    public void afterGroup() {
        logger.debug("after each area1 group");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc1() {
        logger.debug("testArea1Sc1");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc2() {
        logger.debug("testArea1Sc2");
    }

    @Test(groups = {"area2"})
    public void testArea2Sc1() {
        logger.debug("testArea2Sc1");
    }

    @Test(groups = {"area2"})
    public void testArea2Sc2() {
        logger.debug("testArea2Sc2");
    }
}
