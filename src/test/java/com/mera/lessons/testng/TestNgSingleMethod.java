package com.mera.lessons.testng;

import org.testng.annotations.*;

public class TestNgSingleMethod {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before each method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after each method");
    }

    @Test
    public void testArea1Sc1() {
        System.out.println("testArea1Sc1");
    }
}
