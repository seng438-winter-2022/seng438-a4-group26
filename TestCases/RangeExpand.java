package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeExpand {
    private static Range range;
    
    @BeforeClass
    public static void setup () {
        range = new Range (3, 4);
    }

    @AfterClass
    public static void teardown () {
        range = null;
    }

    @Test
    public void testLowerMargin () {
        Range result = Range.expand (range, 1.2, 0);
        Range comp = new Range (1.8, 4);
        assertEquals (comp, result);
    }

    @Test
    public void testUpperMargin () {
        Range result = Range.expand (range, 0, 0.8);
        Range comp = new Range (3, 4.8);
        assertEquals(comp, result);
    }

    @Test
    public void testBothZero () {
        Range result = Range.expand (range, 0, 0);
        assertEquals (range, result);
    }

    @Test
    public void testNull () {
        boolean thrown = false;
        try {
            Range.expand (null, 0, 0);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue (thrown);
    }

    @Test
    public void testNegativeLower () {
        Range result = Range.expand (range, - 0.1, 0);
        Range comp = new Range (3.1, 4);
        assertEquals (comp, result);
    }

    @Test
    public void testNegativeUppper () {
        Range result = Range.expand (range, 0, -0.1);
        Range comp = new Range (3, 3.9);
        assertEquals (comp, result);
    }

    @Test
    public void testOverlap () {
        Range result = Range.expand (range, -3, 0);
        Range comp = new Range (5, 5);
        assertEquals (comp, result);
    }

    // TO DO
    // Line 331 in source code: replaced double operation by second member
    //                          post increment local variable no. 1
    //                          post decrement local variable no. 1
    // Line 332 in source code: replace double operation by second member
    //                          post increment local variable no. 3
    //                          post decrement local variable no. 3
    //                          post increment local variable no. 5
    //                          post decrement local variable no. 5
    // Line 333 in source code: changed conditional boundary
    //                          <= to <
    // Line 334 in source code: replaced double operation with second member
    //                          replaced double division with subtraction
    //                          post increment local variable no. 7
    //                          post decrement local variable no. 7
    //                          post increment local variable no. 9
    //                          post decrement local variable no. 9
    // Line 337 in source code: post increment local variable no. 7
    //                          post decrement local variable no. 7
    //                          post increment local variable no. 9
    //                          post decrement local variable no. 9
}