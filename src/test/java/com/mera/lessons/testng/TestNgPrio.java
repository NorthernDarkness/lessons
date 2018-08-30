package com.mera.lessons.testng;

import org.testng.annotations.*;

public class TestNgPrio {

    @Test(groups = {"area1"}, priority = 5)
    public void testArea1Sc1() {
        System.out.println("testArea1Sc1");
    }

    @Test(groups = {"area1"}, priority = 10)
    public void testArea1Sc2() {
        System.out.println("testArea1Sc2");
        throw new RuntimeException();
    }

    @Test(groups = {"area1"})
    public void testArea1Sc3() {
        System.out.println("testArea1Sc3");
    }

    @Test(groups = {"area1"}, priority = -5)
    public void testArea1Sc4() {

        System.out.println("testArea1Sc4");
        throw new RuntimeException();
    }
}
