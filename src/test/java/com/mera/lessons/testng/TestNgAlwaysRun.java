package com.mera.lessons.testng;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgAlwaysRun {

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
        throw new SkipException("123");
    }

    @AfterClass
//    @AfterClass(groups ="area1", alwaysRun = true)
    public void afterClass() {
        System.out.println("after class");
    }

    @Test(groups = "area1")
    public void testArea1Sc1() {
        System.out.println("testArea1Sc1");
    }
}
