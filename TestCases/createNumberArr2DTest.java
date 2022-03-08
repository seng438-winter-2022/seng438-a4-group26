
package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.*;
import org.jmock.*;
import org.jfree.data.Values2D;


public class createNumberArr2DTest extends DataUtilities {
	private double [][] arr;

	@Before
	public void setUp() throws Exception {
		
	
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testValid2D(){
		double [][] arr2 = {{1,2},{3,4}};
		arr = arr2;
		
		Number[][] testArr = {{1.0,2.0},{3.0,4.0}};
		Number[][]underTest = createNumberArray2D(arr);
		assertEquals(testArr,underTest);
	}
	
	@Test
	public void testValid2DNegatives(){
		double [][] arr2 = {{-1,-2},{-3,-4}};
		arr = arr2;
		
		Number[][] testArr = {{-1.0,-2.0},{-3.0,-4.0}};
		Number[][]underTest = createNumberArray2D(arr);
		assertEquals(testArr,underTest);
	}
	
	@Test
	public void testZzero(){
		double [][] arr2 = {{0},{0}};
		arr = arr2;
		
		Number[][] testArr = {{0.0},{0.0}};
		Number[][]underTest = createNumberArray2D(arr);
		assertEquals(testArr,underTest);
	}
	
	
	@Test(expected=Exception.class)
	public void testNull2D(){
		arr=null;
		
		Number[][]underTest = createNumberArray2D(arr);
		
	}


@Test
public void testEmpty2D(){
	double [][] arr2 = {{},{}};
	arr = arr2;
	
	Number[][] testArr = {{},{}};
	Number[][]underTest = createNumberArray2D(arr);
	assertEquals(testArr,underTest);
	}

@Test
public void testPartialEmpty2D(){
	double [][] arr2 = {{-1.5},{}};
	arr = arr2;
	
	Number[][] testArr = {{-1.5},{}};
	Number[][]underTest = createNumberArray2D(arr);
	assertEquals(testArr,underTest);
	}

}
