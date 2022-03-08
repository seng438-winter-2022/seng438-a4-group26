package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestShiftDouble {
	
	private static Range testee;
	
	@BeforeClass
	public static void setup() {
		testee= new Range(-10,10);
	}

	@Test
	public void testShiftPositiveBy5() {
		Range expected = new Range(-5, 15);
		assertEquals(expected, Range.shift(testee, 5));
	}
	
	@Test
	public void testShiftPositiveBy20() {
		Range expected = new Range(0, 30);
		assertEquals(expected, Range.shift(testee, 20));
	}
	@Test
	public void testShiftNegativeBy5() {
		Range expected = new Range(-15, 5);
		assertEquals(expected, Range.shift(testee, -5));
	}
	
	@Test
	public void testShiftNegativeBy20() {
		Range expected = new Range(-30, 0);
		assertEquals(expected, Range.shift(testee, -20));
	}
	
	@Test
	public void testNullBase() {
		boolean thrown =false;
		try {
			Range.shift(null, 0);
		}catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testShiftbyNaN() {
		Range actual = Range.shift(testee, Double.NaN);
		Double upper = actual.getUpperBound();
		Double lower = actual.getLowerBound();
		boolean NaNCheck=true;
		if(Double.compare(Double.NaN, upper)!=0) {
			NaNCheck=false;
		}
		if(Double.compare(Double.NaN, lower)!=0) {
			NaNCheck=false;
		}
		assertTrue(NaNCheck);
	}
	
	@Test
	public void testShiftByNegativeInf() {
		Range expected = new Range(Double.NEGATIVE_INFINITY, 0);
		assertEquals(expected, Range.shift(testee, Double.NEGATIVE_INFINITY));
	}
	@Test
	public void testShiftByPositiveInf() {
		Range expected = new Range(0, Double.POSITIVE_INFINITY);
		assertEquals(expected, Range.shift(testee, Double.POSITIVE_INFINITY));
	}

}
