package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestScale {
	private static Range testee;
	
	@BeforeClass
	public static void setup() {
		testee=new Range(-1,1);
	}

	@Test
	public void testScaleByPositive() {
		Range expected = new Range(-4,4);
		assertEquals(expected, Range.scale(testee, 4));
	}
	
	@Test
	public void testScaleByNegative() {
		boolean thrown=false;
		try{
			Range.scale(testee, -4);
		}catch(IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	@Test
	public void testNullBase() {
		boolean thrown = false;
		try {
			Range.scale(null, 0);
		}catch(IllegalArgumentException e) {
			thrown =true;
		}
		assertTrue(thrown);
	}
	@Test
	public void testScaleByNaN() {
		Range actual = Range.scale(testee, Double.NaN);
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
	public void testScaleByNegativeInf() {
		boolean thrown=false;
		try {
			Range.scale(testee, Double.NEGATIVE_INFINITY);
		}catch (IllegalArgumentException e) {
			thrown=true;
		}
		assertTrue(thrown);
	}
	@Test
	public void testScaleByPositiveInf() {
		Range expected = new Range(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
		assertEquals(expected, Range.scale(testee, Double.POSITIVE_INFINITY));
	}

}
