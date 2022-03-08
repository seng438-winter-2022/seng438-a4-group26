package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class hashCodeTest{
	private Range tester;
	int hash=0;
	
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
	 * Valid Range testing hash code with a range of zero. Expects a hash code return of 0.0
	 */
	@Test
	public void zeroRangeHash(){
		//tester is set to a valid Range
		 hash = tester.hashCode();
		 Range t = new Range(0,0);
		 assertEquals(0.0,t.hashCode(),0.0);
	}
	
	/**
	 * Valid Range testing hash code with a valid range. Expects a hash code return of an integer
	 */
	@Test
	public void validRangeHash(){
		
		 Range t = new Range(1,1);
		
		 hash = t.hashCode();
		 assertTrue(hash<=Integer.MAX_VALUE&&hash>=Integer.MIN_VALUE);
	}
	
	/**
	 * Testing multiple ranges that are not equal. Thus, assert that the returned hash codes are unique!
	 */
	@Test
	public void twoNotEquals() {
		tester = new Range(-4,5);
		Range tester2=new Range(-3,6);
		
		hash = tester.hashCode();
		int hash2 = tester2.hashCode();
		assertNotEquals(hash,hash2);
	}
	
	/**
	 * Testing multiple ranges that are equal. Thus, assert that the returned hash codes are equal!
	 */
	@Test
	public void twoEquals() {
		tester = new Range(-4,5);
		Range tester2=new Range(-4,5);
		
		hash = tester.hashCode();
		int hash2 = tester2.hashCode();
		assertEquals(hash,hash2);
	}
	
	/**
	 * Testing invalid range hash code. Ensures that an exception is indeed thrown as a result
	 */
	@Test(expected=Exception.class)
	public void invalidRange() {
		tester = new Range(-4,-5);
		//Range tester2=new Range(-3,6);
		
		hash = tester.hashCode();
		
	}
	
	
	/**
	 * Testing multiple ranges that are not equal. Thus, assert that the reture hash codes are unique!
	 */
	@Test(expected=Exception.class)
	public void nullRange() {
		tester = null;
		hash = tester.hashCode();
	
	}
	
}
