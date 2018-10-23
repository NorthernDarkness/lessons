package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgInitDependencies {

    final static Logger logger = Logger.getLogger(TestNgAllInitMethods.class);
    
    @BeforeGroups(groups = "area1")
    public void beforeGroup() {
        logger.debug("before each area1 group");
    }

    @BeforeGroups(groups = "area2", dependsOnMethods = "beforeGroup")
    public void beforeGroup2() {
        logger.debug("before each area2 group");
    }

    @Test(groups = {"area1", "area2"})
    public void test1() {
        logger.debug("test1");
    }

}
