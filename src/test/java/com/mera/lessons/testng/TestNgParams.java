package com.mera.lessons.testng;

import org.testng.annotations.*;

public class TestNgParams {

	@BeforeGroups(groups = "area1")
	@Parameters(value = "param")
	public void beforeGroup(@Optional(value = "123") String param) {
		System.out.println("before group area1" + param);
	}

	@Test(groups = "area1")
	@Parameters(value = "param")
	public void testArea1Sc1(@Optional(value = "123") String param) {
		System.out.println("testArea1Sc1 " + param);
	}

	@Test(groups = "area1")
	@Parameters(value = "setDisabled")
	public void testArea1Sc2(@Optional(value = "true") boolean setDisabled) {
		if(setDisabled) {
			System.out.println("no set");
		}
	}

}
