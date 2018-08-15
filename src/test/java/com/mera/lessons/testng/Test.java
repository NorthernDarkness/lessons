package com.mera.lessons.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;

public class Test {

    @BeforeMethod(groups = "gr1")
    public void before(){
        System.out.println("before");
    }

    @AfterMethod(groups = "gr2")
    public void after(){
        System.out.println("after");
    }

    @org.testng.annotations.Test(groups = {"gr1", "all"})
    public void test1(){

    }

    @org.testng.annotations.Test(groups = {"gr2", "all"})
    public void test2(){
        throw new RuntimeException();
    }
}
