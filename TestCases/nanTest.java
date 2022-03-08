package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class nanTest{
	Range r=new Range(1,2);
	@Before
	public void setUp() throws Exception {
		
	}
	
	@After
	public void tearDown() throws Exception {
		r=null;
	}
	
	@Test
	public void valids(){
	Boolean t= r.isNaNRange();
	assertEquals(false,t);
	}
	
	@Test
	public void invalidLowerBound()
	{
		r=new Range('a',99);
		Boolean testBool=r.isNaNRange();
		assertEquals(false,testBool);
	}
	
	@Test
	public void invalidUpperBound()
	{
		r=new Range(1,'a');
		Boolean testtest=r.isNaNRange();
		assertEquals(false,testtest);
		
	}
	
	@Test
	public void invalidBoth()
	{
		r=new Range ('a','b');
		Boolean testInvalid=r.isNaNRange();
		assertEquals(true,testInvalid);
	}
	
	@Test (expected =Exception.class)
	public void nullTest()
	{
		Range t=null;
		Boolean q=t.isNaNRange();
		assertEquals(true,q);
	}





}
