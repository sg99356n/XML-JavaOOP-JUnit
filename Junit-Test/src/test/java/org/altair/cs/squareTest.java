package org.altair.cs;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class squareTest {

	@Test
	public void test() {
		JunitTesting test = new JunitTesting();
		int output = test.square(5);
		assertEquals(25, output);												
	}

}
