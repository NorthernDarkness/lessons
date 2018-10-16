package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgParams {

	final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
	
	@BeforeGroups(groups = "area1")
	@Parameters(value = "param")
	public void beforeGroup(@Optional(value = "123") String param) {
		logger.debug("before group area1" + param);
	}

	@Test(groups = "area1")
	@Parameters(value = "param")
	public void testArea1Sc1(@Optional(value = "123") String param) {
		logger.debug("testArea1Sc1 " + param);
	}

	@Test(groups = "area1")
	@Parameters(value = "setDisabled")
	public void testArea1Sc2(@Optional(value = "true") boolean setDisabled) {
		if(setDisabled) {
			logger.debug("no set");
		}
	}

}
