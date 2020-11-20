package org.altair.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class counaATest {

	@Test
	public void test() {
		JunitTesting test = new JunitTesting();
		int output = test.count("Alphabet");
		assertEquals(2, output);
	}

}
