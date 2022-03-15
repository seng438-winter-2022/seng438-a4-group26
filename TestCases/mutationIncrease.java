package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class mutationIncrease {
	Range j=new Range (0.0/0.0,90.0);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Boolean result1=j.isNaNRange();
		assertEquals(false, result1);
	}
	
	@Test
	public void test2() {
		j = new Range (0.0/0.0, 0.0/0.0);
		Boolean result1=j.isNaNRange();
		assertEquals(true, result1);
	}
	
	@Test
	public void test3() {
		j = new Range (-2.0, 0.0/0.0);
		Boolean result1=j.isNaNRange();
		assertEquals(false, result1);
	}

}


