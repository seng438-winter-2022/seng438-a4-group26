package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesTestEqual {

	@Test
	public void testEqualSimple() {
		double [][] a = {{1,2,3},{1,2,3},{1,2,3}};
		double [][] b = {{1,2,3},{1,2,3},{1,2,3}};
		
		assertTrue(DataUtilities.equal(a, b));
	}
	
	@Test
	public void testNotEqualSimple() {
		double [][] a = {{1,2,7},{1,2,3},{1,2,3}};
		double [][] b = {{1,2,3},{1,2,3},{1,2,3}};
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void testANull() {
		double [][] a = null;
		double [][] b = {{1,2,3},{1,2,3},{1,2,3}};
		
		assertFalse(DataUtilities.equal(a, b));
	}
	@Test
	public void testBNull() {
		double [][] a = {{1,2,3},{1,2,3},{1,2,3}};
		double [][] b = null;
		
		assertFalse(DataUtilities.equal(a, b));
	}
	@Test
	public void testABNull() {
		double [][] a = null;
		double [][] b = null;
		
		assertTrue(DataUtilities.equal(a, b));
	}
	@Test
	public void testLengthsUnequal() {
		double [][] a = {{1,2,3},{1,2,3}};
		double [][] b = {{1,2,3},{1,2,3},{1,2,3}};
		
		assertFalse(DataUtilities.equal(a, b));
	}

}
