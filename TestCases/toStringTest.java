package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range; 
import org.junit.*;

public class toStringTest
{
	Range y;
	@Before
	public void setUp() throws Exception {
		y = new Range(1,2);
	}

	@After
	public void tearDown() throws Exception {
		y=null;
	}

	@Test
	public void valids()
	{
		String comp="Range[1.0,2.0]";
		String comp1=y.toString();
		//assertTrue(comp1.equals(comp));
		assertEquals(comp,comp1);
	}
	@Test
	public void invalidLower()
	{
		y=new Range('a',99.0);
		String comp2="Range[a,99.0]";
		String comp3=y.toString();
		assertEquals(comp2,comp3);
	}
	@Test
	public void invalidUpper()
	{
		y=new Range(0,'a');
		String comp4="Range[0,a]";
		String comp5=y.toString();
		assertEquals(comp4,comp5);
	}
	@Test(expected=Exception.class)
	public void invalid()
	{
		y=new Range(90,20);
		String comp6=y.toString();
	}
	@Test(expected=Exception.class)
	public void nullTest()
	{
		y=null;
		y.toString();
	}
	
}
