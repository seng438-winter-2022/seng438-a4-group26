package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTestExpandToInclude {
	private static Range testee;
	
	@BeforeClass
	public static void setup() {
		testee= new Range(-10,10);
	}

	@Test
	public void testValueInsideRange() {
		Range expected = new Range(-10,10);
		assertEquals(expected, Range.expandToInclude(testee, 0));
	}

	@Test
	public void testValueOutsideLower() {
		Range expected = new Range(-16,10);
		assertEquals(expected, Range.expandToInclude(testee, -16));
	}
	@Test
	public void testValueOutsideUpper() {
		Range expected = new Range(-10,16);
		assertEquals(expected, Range.expandToInclude(testee, 16));
	}
	
	@Test
	public void testNullRange() {
		Range expected = new Range(7,7);
		assertEquals(expected, Range.expandToInclude(null, 7));
	}
	
	@Test
	public void testNAN() {
		Range expected = new Range(-10,10);
		assertEquals(expected, Range.expandToInclude(testee, Double.NaN));
	}
	@Test
	public void testNegativeInf() {
		Range expected = new Range(Double.NEGATIVE_INFINITY,10);
		assertEquals(expected, Range.expandToInclude(testee, Double.NEGATIVE_INFINITY));
	}
	@Test
	public void testPostiveInf() {
		Range expected = new Range(-10,Double.POSITIVE_INFINITY);
		assertEquals(expected, Range.expandToInclude(testee, Double.POSITIVE_INFINITY));
	}
}
