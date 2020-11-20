package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class counaATest {

	@Test
	public void test() {
		JunitTesting test = new JunitTesting();
		int output = test.count("Alphabet");
		assertEquals(2, output);
	}

}
