package com.mera.lessons.testng;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class TestNgRetry {

	int i;

	@Test(retryAnalyzer = RetryAnalizer.class)
	public void testArea1Sc1() {
		if (i++ < 2) {
			fail();
		}
		System.out.println("testArea1Sc1");
	}

}
