package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;


public class RangeConstrainTest {
	private static Range range;

    @BeforeClass
    public static void setup () {
        range = new Range (-2, 12);
    }

    @AfterClass
    public static void teardown () {
        range = null;
    }

    @Test
    public void testRangePositive () {
        double res = range.constrain(5);
        assertEquals (5.0, res, 0);
    }

    @Test
    public void testRangeNegative () {
        double res = range.constrain(-1);
        assertEquals (-1.0, res, 0);
    }
    
    @Test
    public void testRangeOutOfRangeAbove () {
        double res = range.constrain(154);
        assertEquals (12.0, res, 0);
    }
    
    @Test
    public void testRangeOutOfRangeBelow () {
        double res = range.constrain(-62);
        assertEquals (-2.0, res, 0);
    }
    
    @Test
    public void testRangeBoundaryUpper () {
        double res = range.constrain(12);
        assertEquals (12.0, res, 0);
    }
    
    @Test
    public void testRangeBoundaryLower () {
        double res = range.constrain(-2);
        assertEquals (-2.0, res, 0);
    }

    // TO DO
    // Line 188 in source code: post increment of loval variable no. 1
    //                          post decrement of local variable no. 1
    // Line 189 in source code: remove call to contains
    //                          removed conditional and replaced with true
    //                          negated local variable no. 1
    //                          != to <
    //                          != to >
    //                          post increment of local variable no. 1
    //                          post decrement of local variable no. 1
    //                          pre increment of local variable no. 1
    //                          pre decrement of local variable no. 1
    // Line 190 in source code: changed conditional boundary
    //                          negated double field upper
    //                          <= to <
    //                          post incrememnt local variable no. 1
    //                          post decrement local variable no. 1
    //                          pre increment of local variable no. 1
    //                          pre decrement of local variable no. 1
    // Line 191 in source code: post increment of double field upper
    //                          post decrement of double field upper
    // Line 193 in source code: changed conditional boundary
    //                          removed condition and replaced with true
    //                          negated double field lower
    //                          <= to <
    //                          <= to ==
    //                          post incrememnt local variable no. 1
    //                          post decrement local variable no. 1
    //                          pre increment of local variable no. 1
    //                          pre decrement of local variable no. 1
    // Line 194 in source code: post increment of double field lower
    //                          post decrement of double field lower
    // Line 197 in source code: post increment local variable no. 3
    //                          post decrement local variable no. 3
}
