package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class createNumberArrayTest extends DataUtilities {
	double [] testArr= {1,2};
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		testArr=null;
	}

	@Test
	public void PositiveTest() {
		Number [] a1=createNumberArray(testArr);
		Number [] a2 = {1.0,2.0};
		assertEquals(a1,a2);
	}
	@Test
	public void negativeTest()
	{
		testArr=new double[] {-1,-2};
		Number [] a3= {-1.0,-2.0};
		Number [] a4=createNumberArray(testArr);
		assertEquals(a3,a4);
	}
	@Test
	public void zeroTest()
	{
		testArr= new double [] {0,0};
		Number [] a5= {0.0,0.0};
		Number [] a6=createNumberArray(testArr);
		assertEquals(a5,a6);
		}
	@Test(expected=Exception.class)
	public void nullTester()
	{
		testArr=null;
		Number [] a7=null;
		Number [] a8=createNumberArray(testArr);
		//assertEquals(a7,a8);
	}

	}


