package com.mera.training.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgAllInitMethods {

	final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
	
	@BeforeSuite
	public void beforeSuite() {
		logger.debug("before suite");
	}

	@BeforeClass
	public void beforeClass() {
		logger.debug("before class");
	}

	@BeforeGroups(groups = "area1")
	public void beforeGroup() {
		logger.debug("before group");
	}

	@BeforeMethod
	public void beforeMethod() {
		logger.debug("before method");
	}

	@Test(groups = { "area1" })
    public void testArea1Sc2() {
		logger.debug("testArea1Sc2");
	}

	@AfterSuite
	public void afterSuite() {
		logger.debug("after suite");
	}

	@AfterClass
	public void afterClass() {
		logger.debug("after class");
	}

	@AfterGroups(groups = "area1")
	public void afterGroup() {
		logger.debug("after group");
	}

	@AfterMethod
	public void afterMethod() {
		logger.debug("after method");
	}
}
