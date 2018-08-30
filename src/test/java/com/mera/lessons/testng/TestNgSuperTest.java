package com.mera.lessons.testng;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgSuperTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before each method super");
    }

    @BeforeGroups(groups = "area1")
    public void beforeGroup() {
        System.err.println("before each area1 group super");
    }

    @Test(groups = {"area1"})
    public void testArea1Sc1() {
        System.out.println("testArea1Sc1");
    }


}
