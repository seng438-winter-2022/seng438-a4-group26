package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.*;

public class RangeEquals {
    private static Range range;

    @BeforeClass
    public static void setup () {
        range = new Range (2, 10);
    }

    @AfterClass
    public static void teardown () {
        range = null;
    }

    @Test
    public void testNonEquNull () {
        boolean result = range.equals (null);
        assertFalse (result);
    }

    @Test
    public void testEquRange () {
        Range param = new Range (2, 10);
        boolean result = range.equals (param);
        assertTrue(result);
    }

    @Test
    public void testNonEquLowerRange () {
        Range param = new Range (1, 10);
        boolean result = range.equals (param);
        assertFalse (result);
    }

    @Test
    public void testNonEquUpperRange () {
        Range param = new Range (2, 7);
        boolean result = range.equals (param);
        assertFalse (result);
    }

    @Test
    public void testNonEquNonRange () {
        String param = "Hello";
        boolean result = range.equals (param);
        assertFalse (result);
    }

    @Test
    public void testRangeGreater () {
        Range param = new Range (-3, 5);
        boolean result = range.equals (param);
        assertFalse (result);
    }

    // TO DO
    // Line 426 in source code: != to > (no idea how to work with this)
    // Line 430 in source code: == to < (this.lower must be > range.lower)
    // Line 433 in source code: == to <= (this.upper must be > range.lower)
    // Line 436 in source code: substituted 1 with -1 (what happens with this?)
}