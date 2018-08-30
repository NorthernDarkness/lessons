package com.mera.lessons.testng;

import org.testng.annotations.*;

public class TestNgDependencies {

    @Test(dependsOnMethods = "testArea1Sc2")
    public void testArea1Sc1() {
        System.out.println("testArea1Sc1");
    }

    @Test(dependsOnGroups = "area1")
    public void testArea1Sc2() {
        System.out.println("testArea1Sc2");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc3() {
        System.out.println("testArea1Sc3");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc4() {
        System.out.println("testArea1Sc4");
    }
    
}
