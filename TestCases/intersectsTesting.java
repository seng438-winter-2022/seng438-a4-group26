package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class intersectsTesting{
	private Range tester;
	
	
	@Before
	public void setUp() throws Exception {
		tester=new Range(3,8);
		//hash=5;
	}

	@After
	public void tearDown() throws Exception {
		tester=null;
	}
	
	/**
	 * Test with identical ranges. Thus, should return true for intersects.
	 */
	@Test
	public void intersectEqualRanges() {
		
	Range test2 = new Range(3,8);
	assertTrue(tester.intersects(test2));
	
	}
	
	/**
	 * Test with fully overlapping ranges. Thus, intersect should be true.
	 */
	@Test
	public void intersectOverlapRanges() {
		
	Range test2 = new Range(5,7);
	assertTrue(tester.intersects(test2));
	
	}
	
	
	/**
	 * Test with Partial Overlap. Thus, should return true for intersects.
	 */
	@Test
	public void intersectPartialOverlapRanges() {
		
	Range test2 = new Range(-4,4);
	assertTrue(tester.intersects(test2));
	
	}
	
	/**
	 * Test with ranges that do not overlap. Thus, should return false for intersects.
	 */
	@Test
	public void intersectNoOverlap() {
		
	Range test2 = new Range(-5,-2);
	assertFalse(tester.intersects(test2));
	
	}
	
	/**
	 * Test with a null range. Thus, should throw exception.
	 */
	@Test(expected = Exception.class)
	public void intersectNullRange() {
		
	Range test2 = null;
	assertTrue(tester.intersects(test2));
	
	}
	
	/**
	 * Test with an invalid range. Thus, an exception should be thrown.
	 */
	@Test(expected = Exception.class)
	public void intersectInvalidRange() {
		
	Range test2 = new Range(3,-1);
	assertTrue(tester.intersects(test2));
	
	}
}
