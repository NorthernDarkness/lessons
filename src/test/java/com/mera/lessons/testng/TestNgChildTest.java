package com.mera.lessons.testng;

import org.testng.annotations.*;
import org.testng.log4testng.Logger;

public class TestNgChildTest extends TestNgSuperTest{

    @BeforeMethod
    @Override
    public void beforeMethod() {
        System.out.println("before each method overriden");
    }

    @BeforeGroups(groups = "area1")
    public void beforeGroup2() {
        System.err.println("before each area1 group child");
    }


    @Test(groups = {"area1"})
    public void testArea1Sc2() {
        System.out.println("testArea1Sc2");
    }

}
