package com.mera.training.testng;

import static org.testng.Assert.fail;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestNgRetry {

	final static Logger logger = org.apache.log4j.Logger.getLogger(TestNgAllInitMethods.class);
	
	int i;
//	JcatRerunHelper.class
	@Test(retryAnalyzer = RetryAnalizer.class)
	public void testArea1Sc1() {
		if (i++ < 2) {
			fail();
		}
		logger.debug("testArea1Sc1");
	}

}
