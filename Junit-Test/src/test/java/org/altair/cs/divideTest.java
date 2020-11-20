package org.altair.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.Before;

/*************************************************************************************
 * Test Driven Development using JUnit 5
 *
 * Scenario: Unit testing divide() from JunitTesting.java
 * Description: 
 * To test edge cases of dividing a number: Exhaustive testing  
 *************************************************************************************/

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class divideTest {

	JunitTesting test;
	
	@Before
	public  void init() {
		
		/*******************************************************
		 * Initializing instance variable before executing @Test
		 *******************************************************/
		
		test = new JunitTesting();
	}
	
	@Test
	public void test() {
		
		/*********************************************
		 * Positive test case: Dividing an odd integer
		 *********************************************/
		
		assertEquals(2.0, test.divide(5, 2), "Dividing an odd integer");
	}
	
	@Test
	public void test2() {
		
		/*******************************************************
		 * Positive test case: Dividing an even negative integer
		 *******************************************************/

		assertEquals(-3.0, test.divide(-6, 2), "Dividing an even integer");
	}
	
	@Test
	public void test3() {
		
		/**********************************************
		 * Positive test case: Dividing an even integer
		 **********************************************/

		assertEquals(3.0, test.divide(6, 2), "Dividing an even integer");
	}
	
	@Test
	public void test4() {
		
		/***************************************************
		 * Positive test case: Divide by an negative integer
		 ***************************************************/

		assertEquals(-3.0, test.divide(6, -2), "Dividing an even integer");
	}
	
	@Test
	public void divideZero() {
		
		/*************************************
		 * Negative test case: Divide by zero
		 *************************************/
			
		assertThrows(ArithmeticException.class,() -> test.divide(5, 0), "Divide by zero method");
	}
	
	@Test
	public void divideZero2() {
		
		/*****************************************
		 * Negative test case: Divide zero by zero
		 *****************************************/
			
		assertThrows(ArithmeticException.class,() -> test.divide(0, 0), "Divide by zero method");
	}

}
