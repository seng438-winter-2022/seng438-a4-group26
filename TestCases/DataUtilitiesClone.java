package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.junit.*;

public class DataUtilitiesClone {
    @Test
    public void testNull () {
        Boolean thrown = false;
        try {
            DataUtilities.clone(null);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testSymmetrical () {
        double [][] param = { {10.0, 13.1},
                              {-3, -7.6},
                              {13, 12} };
        double [][] result = DataUtilities.clone(param);
        assertArrayEquals(param, result); 
    }

    @Test
    public void testAssymetrical () {
        double [][] param = { {10.0, 13.1, 3},
                              {-3, -7.6, -2, -17.9, 2.09},
                              {13} };
        double [][] result = DataUtilities.clone(param);
        assertArrayEquals(param, result);
    }

    @Test
    public void testNullRow () {
        double [][] param = { {10.0, 13.1, 3},
                              {-3, -7.6, -2},
                              {} };
        double [][] result = DataUtilities.clone(param);
        assertArrayEquals (param, result);
    }

    // TO DO
    // Line 104 in source code: less than to not equal survived in the for loop (EQUIVALENT)
    // Line 105 in source code: removed conditional and replace with true, survived (DONE)
}