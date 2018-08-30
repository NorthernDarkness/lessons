package com.mera.lessons.testng;

import org.testng.annotations.*;

public class TestNgIgnore {

    @Test
    public void testArea1Sc1() {
        System.out.println("testArea1Sc1");
    }

    @Test
    public void testArea1Sc2() {
        System.out.println("testArea1Sc2");
    }

    @Test
    @Ignore
    public void testArea1Sc3() {
        System.out.println("testArea1Sc3");
    }

    @Test
    public void testArea1Sc4() {
        System.out.println("testArea1Sc4");
    }
}
