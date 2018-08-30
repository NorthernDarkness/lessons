package com.mera.lessons.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviders {

	@Test(dataProvider = "dp")
	public void testArea1Sc1(String type, String lanTopology, String switchSide, String portAssignment) {
		System.out.println("Create VLAN " + String.join(" ", type, lanTopology, switchSide, portAssignment));
	}

	@DataProvider(name = "dp")
	public static Object[][] getDp() {
		return new Object[][] { { "PRIVATE", "DATA", "LEFT", "MANUAL" }, { "PRIVATE", "BASE", "RIGHT", "MANUAL" }, };
	}
}
