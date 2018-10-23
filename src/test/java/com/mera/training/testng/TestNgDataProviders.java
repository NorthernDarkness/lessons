package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviders {

	final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
	
	@Test(dataProvider = "dp")
	public void testArea1Sc1(String type, String lanTopology, String switchSide, String portAssignment) {
		logger.debug("Create VLAN " + String.join(" ", type, lanTopology, switchSide, portAssignment));
	}

	@DataProvider(name = "dp")
	public static Object[][] getDp() {
		return new Object[][] { { "PRIVATE", "DATA", "LEFT", "MANUAL" },
				{ "PRIVATE", "BASE", "RIGHT", "MANUAL" }, };
	}
}
