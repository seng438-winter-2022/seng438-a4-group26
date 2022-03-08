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
        assertEquals (null, result);
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
}