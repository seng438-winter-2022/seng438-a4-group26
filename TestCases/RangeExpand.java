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
    // Mutations
    @Test
    public void testEqual () { // range modification makes lower and upper equal
        Range origin = new Range (1,10);
        Range result = Range.expand(origin,-5, -0.5);
        Range comp = new Range (5,5);
        assertEquals (comp, result);
    }

    @Test
    public void testBoundRemoval () { // test when 331 and 332 remove the lower and upper bounds
        Range origin = new Range (-14, 72);
        Range result = Range.expand(origin,5, 0.3);
        Range comp = new Range (-444,97.8);
        assertEquals (comp, result);
    }

    @Test
    public void testOverlapUpperLower () { // test when range modifications overlap to ensure both lower and upper must be used and subtraction cannot be used
        Range origin = new Range (-14, 72);
        Range result = Range.expand(origin,-5, 0.3);
        Range comp = new Range (256.9,256.9);
        assertEquals (comp, result);
    }

    // TO DO
    // Line 331 in source code: replaced double operation by second member (DONE)
    //                          post increment local variable no. 1 (lower margin never used again so uncatchable)
    //                          post decrement local variable no. 1 (lower margin never used again so uncatchable)
    // Line 332 in source code: replace double operation by second member (DONE)
    //                          post increment local variable no. 3 (length is recalculated before being used again)
    //                          post decrement local variable no. 3 (length is recalculated before being used again)
    //                          post increment local variable no. 5 (upper margin never used again)
    //                          post decrement local variable no. 5 (upper margin never used again)
    // Line 333 in source code: changed conditional boundary (DONE)
    //                          <= to < (compilation issue)
    // Line 334 in source code: replaced double operation with second member (DONE)
    //                          replaced double division with subtraction (DONE)
    //                          post increment local variable no. 7 (Variable do not exist in code ??)
    //                          post decrement local variable no. 7 (Variable do not exist in code ??)
    //                          post increment local variable no. 9 (Variable do not exist in code ??)
    //                          post decrement local variable no. 9 (Variable do not exist in code ??)
    // Line 337 in source code: post increment local variable no. 7 (Variable do not exist in code ??)
    //                          post decrement local variable no. 7 (Variable do not exist in code ??)
    //                          post increment local variable no. 9 (Variable do not exist in code ??)
    //                          post decrement local variable no. 9 (Variable do not exist in code ??)
}