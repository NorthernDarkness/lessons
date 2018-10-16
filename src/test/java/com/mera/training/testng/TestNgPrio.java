package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgPrio {

    final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
    
    @Test(groups = {"area1"}, priority = 5)
    public void testArea1Sc1() {
        logger.debug("testArea1Sc1");
    }

    @Test(groups = {"area1"}, priority = 10)
    public void testArea1Sc2() {
        logger.debug("testArea1Sc2");
        throw new RuntimeException();
    }

    @Test(groups = {"area1"})
    public void testArea1Sc3() {
        logger.debug("testArea1Sc3");
    }

    @Test(groups = {"area1"}, priority = -5)
    public void testArea1Sc4() {

        logger.debug("testArea1Sc4");
        throw new RuntimeException();
    }
}
