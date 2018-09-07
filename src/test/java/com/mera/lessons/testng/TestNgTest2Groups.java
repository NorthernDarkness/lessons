package com.mera.lessons.testng;

import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import static org.testng.Assert.fail;

public class TestNgTest2Groups {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("before each method for area1 group");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("after each method for area1 group");
    }

    @BeforeGroups(groups = "area1")
    public void beforeGroup() {
        System.err.println("before each area1 group");
    }

    @AfterGroups(groups = "area1")
    public void afterGroup() {
        System.err.println("after each area1 group");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc1() {
        System.out.println("testArea1Sc1");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc2() {
        System.out.println("testArea1Sc2");
    }

    @Test(groups = {"area2"})
    public void testArea2Sc1() {
        System.out.println("testArea2Sc1");
    }

    @Test(groups = {"area2"})
    public void testArea2Sc2() {
        System.out.println("testArea2Sc2");
    }
}
