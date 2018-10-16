package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgIgnore {

    final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
    
    @Test
    public void testArea1Sc1() {
        logger.debug("testArea1Sc1");
    }

    @Test
    public void testArea1Sc2() {
        logger.debug("testArea1Sc2");
    }

    @Test
    @Ignore
    public void testArea1Sc3() {
        logger.debug("testArea1Sc3");
    }

    @Test
    public void testArea1Sc4() {
        logger.debug("testArea1Sc4");
    }
}
