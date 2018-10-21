package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgChildTest extends TestNgSuperTest{

    final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
    
    @BeforeMethod
    @Override
    public void beforeMethod() {
        logger.debug("before each method overriden");
    }

    @BeforeGroups(groups = "area1")
    public void beforeGroup2() {
        logger.debug("before each area1 group child");
    }


    @Test(groups = {"area1"})
    public void testArea1Sc2() {
        logger.debug("testArea1Sc2");
    }

}
