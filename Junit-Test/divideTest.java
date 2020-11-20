package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class divideTest {

	@Test
	public void test() {
		/*********************
		 * Positive test cases
		 *********************/
		JunitTesting test = new JunitTesting();
		double output = test.divide(5, 2);
		System.out.println(output);
		assertEquals(2.0, output);
	}

}
