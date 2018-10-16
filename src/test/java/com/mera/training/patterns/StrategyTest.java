package com.mera.training.patterns;

import java.util.function.Consumer;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class StrategyTest {

	@Test
	public void testStrategy1() {
		testSmth(9, m -> {
			throw new SkipException(m);
		});
	}

	@Test
	public void testStrategy2() {
		testSmth(-1, m -> {
			throw new SkipException(m);
		});
	}

	@Test
	public void testStrategy3() {
		testSmth(-1, m -> {
			System.out.println(m);
			assert false;
		});
	}
	
	private void testSmth(int value, Consumer<String> strategy) {
		if (value < 0) {
			strategy.accept("Validation failed");
		}
	}

}
