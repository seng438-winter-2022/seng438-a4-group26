package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class shiftTest{
	private Range tester;
	private double delta;
	private boolean allowZero;
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		tester=null;
	}

	/**
	 * Test with valid base range, delta is negative and allowZero is true
	 * Expects success, with bounds subtracted by seven
	 */
	@Test
	public void allValidParams(){
		tester = new Range(-3, 3);
		delta = -7;
		allowZero = true;
		
		Range local = tester.shift(tester, delta, allowZero);
		assertEquals(-4, local.getUpperBound(), 0.0);
	}
	
	/**
	 * Test with valid base range, delta is 0 and allowZero is true
	 * Expects the returned range to be identical to original range
	 */
	@Test
	public void deltaIsZero(){
		tester = new Range(-3, 3);
		delta = 0;
		allowZero = true;
		
		Range local = tester.shift(tester, delta, allowZero);
		assertTrue(tester.equals(local));
	}
	
	/**
	 * Test with valid base range, delta is positive and allowZero is true
	 * Expects success
	 */
	@Test
	public void deltaIsPositive(){
		tester = new Range(-3, 3);
		delta = 4;
		allowZero = true;
		
		Range local = tester.shift(tester, delta, allowZero);
		assertEquals(1, local.getLowerBound(), 0.0);
	}
	
	/**
	 * Test with valid base range, delta is negative and allowZero is false
	 * Expects UpperBound to be 0 to prevent it crossing zero 
	 */
	@Test
	public void allowZeroFalse(){
		tester = new Range(-3, 3);
		delta = -5;
		allowZero = false;
		
		Range local = tester.shift(tester, delta, allowZero);
		assertEquals(0, local.getUpperBound(), 0.0);
	}
	
	/**
	 * Test with valid base range, delta is zero and allowZero is false
	 * Expects returned range to be identical to original range 
	 */
	@Test
	public void allowZeroFalseWithZeroDelta(){
		tester = new Range(-3, 3);
		delta = 0;
		allowZero = false;
		
		Range local = tester.shift(tester, delta, allowZero);
		assertTrue(tester.equals(local));
	}
	
	/**
	 * Test with valid range, positive delta and false allow zero
	 * Expects that lowerbound will be 0 since it cannot successfully cross 0.0
	 */
	@Test
	public void allowZeroFalsewithPositiveDeltaTest() {
		tester = new Range(-3, 3);
		delta = 4;
		allowZero = false;
		
		Range local = tester.shift(tester, delta, allowZero);
		assertEquals(0, local.getLowerBound(),0.0);
	
	}
	
	
	/**
	 * Test with a NULL base. Expects exception as null is not permitted
	 */
	@Test(expected = Exception.class)
	public void nullTest() {
		Range tester2 = null;
		delta = 4;
		allowZero = false;
		
		Range local = tester2.shift(tester, delta, allowZero);
		//assertEquals(0, local.getLowerBound(),0.0);
	
	}
	
}
