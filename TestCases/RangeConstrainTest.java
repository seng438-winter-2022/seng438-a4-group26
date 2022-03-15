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
        double res = range.constrain(13);
        assertEquals (12.0, res, 0);
    }
    
    @Test
    public void testRangeOutOfRangeBelow () {
        double res = range.constrain(-3);
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
    // Line 188 in source code: post increment of loval variable no. 1 (DONE - modified)
    //                          post decrement of local variable no. 1 (DONE - modified)
    // Line 189 in source code: remove call to contains (EQUIVALENT - if replaced, the nested conditions catch it)
    //                          removed conditional and replaced with true (EQUIVALENT - if replaced, the nested conditions catch it)
    //                          negated local variable no. 1 (DONE - modified)
    //                          != to < (COMPILER)
    //                          != to > (COMPILER)
    //                          post increment of local variable no. 1 (DONE - modified)
    //                          post decrement of local variable no. 1 (DONE - modified)
    //                          pre increment of local variable no. 1 (DONE - modified)
    //                          pre decrement of local variable no. 1 (DONE - modified)
    // Line 190 in source code: changed conditional boundary (EQUIVALENT - due to previous condition)
    //                          negated double field upper (EQUIVALENT - does not modify conditional results)
    //                          <= to < (COMPILER)
    //                          post incrememnt local variable no. 1 (Not caught, never used again)
    //                          post decrement local variable no. 1 (Not caught, never used again)
    //                          pre increment of local variable no. 1 (Not caught, never used again)
    //                          pre decrement of local variable no. 1 (Not caught, never used again)
    // Line 191 in source code: post increment of double field upper (Not caught, never used again)
    //                          post decrement of double field upper (Not caught, never used again)
    // Line 193 in source code: changed conditional boundary (EQUIVALENT - due to previous condition)
    //                          removed condition and replaced with true (EQUIVALENT - due to previous condition)
    //                          negated double field lower (DONE - modified)
    //                          <= to < (COMPILER)
    //                          <= to == (COMPILER)
    //                          post incrememnt local variable no. 1 (Not caught, never used again)
    //                          post decrement local variable no. 1 (Not caught, never used again)
    //                          pre increment of local variable no. 1 (Not caught, never used again)
    //                          pre decrement of local variable no. 1 (Not caught, never used again)
    // Line 194 in source code: post increment of double field lower (Not caught, never used again)
    //                          post decrement of double field lower (Not caught, never used again)
    // Line 197 in source code: post increment local variable no. 3 (Not caught, never used again)
    //                          post decrement local variable no. 3 (Not caught, never used again)
}
