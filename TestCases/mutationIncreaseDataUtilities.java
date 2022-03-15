package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class mutationIncreaseDataUtilities {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(timeout=100)
	public void test() throws InterruptedException {
	double [] tester = {1.0,2.0,3.0};
	Number [] jo=DataUtilities.createNumberArray(tester);
	
	assertNotEquals(tester,jo);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nullPermitTest() {
		//int [] rows = {1,3,5,7};
		DataUtilities.calculateColumnTotal(null, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nullNotPermittedNumberArray() {
		DataUtilities.createNumberArray(null);
	}

}
