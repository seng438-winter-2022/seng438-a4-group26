package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.*;

public class RangeCombineIgnoringNaN {

    @Test
    public void testBothNull () {
        Range result = Range.combineIgnoringNaN (null, null);
        assertEquals (null, result);
    }

    @Test
    public void test1stNull () {
        Range param = new Range (1, 14);
        Range result = Range.combineIgnoringNaN (param, null);
        assertEquals (param, result);
    }

    @Test
    public void test2ndNull () {
        Range param = new Range (1, 14);
        Range result = Range.combineIgnoringNaN (null, param);
        assertEquals (param, result);
    }

    @Test
    public void testNaNParam () {
        Range param1 = new Range (1, Double.NaN);
        Range param2 = new Range (Double.NaN, 3);
        Range result = Range.combineIgnoringNaN (param1, param2);
        Range comp = new Range (1,3);
        assertEquals (null, comp);
    }

    @Test
    public void testNoIssues () {
        Range param1 = new Range (3, 8);
        Range param2 = new Range (1, 5);
        Range comp = new Range (1, 8);
        Range result = Range.combineIgnoringNaN(param1, param2);
        assertEquals (comp, result);
    }

    @Test
    public void testNaNRange1 () {
        Range param1 = new Range (Double.NaN, Double.NaN);
        Range param2 = null;
        Range result = Range.combineIgnoringNaN(param1, param2);
        assertEquals (null, result);
    }

    @Test
    public void testNaNRange2 () {
        Range param2 = new Range (Double.NaN, Double.NaN);
        Range param1 = null;
        Range result = Range.combineIgnoringNaN(param1, param2);
        assertEquals (null, result);
    }

    @Test
    public void testBothNaN () {
        Range param1 = new Range (Double.NaN, Double.NaN);
        Range param2 = new Range (Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN (param1, param2);
        assertEquals (null, result);
    }

    // Mutations
    @Test
    public void testRange2LowerisMin () { // for argument bug in min
        Range param1 = new Range (1,3);
        Range param2 = new Range (0,8);
        Range result = Range.combineIgnoringNaN (param1, param2);
        Range comp = new Range (0, 8);
        assertEquals (comp, result);
    }

    @Test
    public void bothMinNaN () { // both min but not max is NaN
        Range param1 = new Range (Double.NaN, 8);
        Range param2 = new Range (Double.NaN, 3);
        Range result = Range.combineIgnoringNaN (param1, param2);
        
        if (!result.getLowerBound().isNaN) {
            fail ();
        }
        if (result.getUpperBound() != 8.0) {
            fail ();
        }
    }

    @Test
    public void bothMaxNaN () { // both max but not min are NaN
        Range param1 = new Range (-3, Double.NaN);
        Range param2 = new Range (12, Double.NaN);
        Range result = Range.combineIgnoringNaN (param1, param2);
        if (result.getLowerBound() != -3.0) {
            fail ();
        }
        if (!result.getUpperBound().isNaN()) {
            fail ();
        }
    }

    // TO DO
    // Line 242 in source code: == to <= (COMPILER)
    // Line 248 in source code: == to <= (COMPILER)
    // Line 253 in source code: replace call to min with argument (DONE)
    // Line 255 in source code: removed condition and replaced with true (first condition) (DONE)
    //                          removed condition and replaced with true (second condition) (DONE)
    //                          negated double local variable no. 2
    //                          negated double local variable no. 4
    //                          == to < (first condition) (COMPILER)
    //                          == to < (second condition) (COMPILER)
    //                          == to <= (first condition) (COMPILER)
    //                          == to <= (second condition) (COMPILER)
    //                          post increment local variable no. 4
    //                          post decrement local variable no. 4
    //                          pre increment local variable no. 4
    //                          pre decrement local variable no. 4
    // Line 258 in source code: post increment local variable no. 4 (Cannot be checked)
    //                          post decrement local variable no. 4 (Cannot be checked)
    //                          post increment local variable no. 2 (Cannot be checked)
    //                          post decrement local variable no. 2 (Cannot be checked)
}