package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesCalculateColumnTotalArrayTest {
    
    @Test
    public void testCCTAValid () {
        Mockery mockingContext = new Mockery ();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking (new Expectations () {
            {
                one(values).getRowCount ();
                will(returnValue(2));
                // first row
                one(values).getValue(0,0);
                will(returnValue(13.2));
                one(values).getValue(0,1);
                will(returnValue(1.7));
                one(values).getValue(0,2);
                will(returnValue(2.7));
                // second row
                one(values).getValue(1,0);
                will(returnValue(4));
                one(values).getValue(1,1);
                will(returnValue(17));
                one(values).getValue(1,2);
                will(returnValue(2.1));
            }
        });

        int [] validRows = {0,1};
        double result = DataUtilities.calculateColumnTotal (values, 1, validRows);

        assertEquals (result, 18.7, 0);
    }
    
    @Test 
    public void testCCTAOutOfBoundsColumn () {
        Mockery mockingContext = new Mockery ();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking (new Expectations () {
            {
                one(values).getRowCount ();
                will(returnValue(2));
                // first row
                one(values).getValue(0,0);
                will(returnValue(13.2));
                one(values).getValue(0,1);
                will(returnValue(1.7));
                one(values).getValue(0,2);
                will(returnValue(2.7));
                // second row
                one(values).getValue(1,0);
                will(returnValue(4));
                one(values).getValue(1,1);
                will(returnValue(17));
                one(values).getValue(1,2);
                will(returnValue(2.1));
                
                one(values).getValue(0, 7); // based on Values 2D
                will(throwException(new IndexOutOfBoundsException ("7")));
            }
        });

        int [] validRows = {0,1};
        
        Boolean thrown =false;
        try {
        	double result = DataUtilities.calculateColumnTotal (values, 7, validRows);
        } catch (IndexOutOfBoundsException e) {
        	thrown=true;
        }
        assertTrue(thrown);
    }
    
    @Test 
    public void testCCTABoundaryColumn () {
        Mockery mockingContext = new Mockery ();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking (new Expectations () {
            {
                one(values).getRowCount ();
                will(returnValue(2));
                // first row
                one(values).getValue(0,0);
                will(returnValue(13.2));
                one(values).getValue(0,1);
                will(returnValue(1.7));
                one(values).getValue(0,2);
                will(returnValue(2.7));
                // second row
                one(values).getValue(1,0);
                will(returnValue(4));
                one(values).getValue(1,1);
                will(returnValue(17));
                one(values).getValue(1,2);
                will(returnValue(2.1));
            }
        });

        int [] validRows = {0,1};
        double result = DataUtilities.calculateColumnTotal (values, 0, validRows);

        assertEquals (result, 17.2, 0);
    }
    
    @Test 
    public void testCCTAExtraValidRows () {
        Mockery mockingContext = new Mockery ();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking (new Expectations () {
            {
                one(values).getRowCount ();
                will(returnValue(2));
                // first row
                one(values).getValue(0,0);
                will(returnValue(13.2));
                one(values).getValue(0,1);
                will(returnValue(1.7));
                one(values).getValue(0,2);
                will(returnValue(2.7));
                // second row
                one(values).getValue(1,0);
                will(returnValue(4));
                one(values).getValue(1,1);
                will(returnValue(17));
                one(values).getValue(1,2);
                will(returnValue(2.1));
            }
        });

        int [] validRows = {0,4};
        double result = DataUtilities.calculateColumnTotal (values, 1, validRows);

        assertEquals (result, 1.7, 0);
    }
    
    @Test
    public void testCCTANullData () {
        int [] validRows = {0,1};
        
        Boolean thrown = false;
        try {
            double result = DataUtilities.calculateColumnTotal (null, 1, validRows);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    
    @Test 
    public void testCCTAENegativeValidValues () {
        Mockery mockingContext = new Mockery ();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking (new Expectations () {
            {
                one(values).getRowCount ();
                will(returnValue(2));
                // first row
                one(values).getValue(0,0);
                will(returnValue(-13.2));
                one(values).getValue(0,1);
                will(returnValue(-1.7));
                one(values).getValue(0,2);
                will(returnValue(2.7));
                // second row
                one(values).getValue(1,0);
                will(returnValue(4));
                one(values).getValue(1,1);
                will(returnValue(17));
                one(values).getValue(1,2);
                will(returnValue(-2.1));
            }
        });

        int [] validRows = {0,1};
        double result = DataUtilities.calculateColumnTotal (values, 1, validRows);

        assertEquals (result, 15.3, 0);
    }
    
    @Test
    public void testCCTAEmptyValidRows () {
        Mockery mockingContext = new Mockery ();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking (new Expectations () {
            {
                one(values).getRowCount ();
                will(returnValue(2));
                // first row
                one(values).getValue(0,0);
                will(returnValue(13.2));
                one(values).getValue(0,1);
                will(returnValue(1.7));
                one(values).getValue(0,2);
                will(returnValue(2.7));
                // second row
                one(values).getValue(1,0);
                will(returnValue(4));
                one(values).getValue(1,1);
                will(returnValue(17));
                one(values).getValue(1,2);
                will(returnValue(2.1));
            }
        });

        int [] validRows = {};
        double result = DataUtilities.calculateColumnTotal (values, 1, validRows);
        assertEquals (result, 0, 0);
    }
    
    // TO DO
    // Line 150 in source code: removed call fails to catch null not permitted for data type (maybe make sure a case with null data?)
    // Line 153 in source code: less than changed to not equal survived in for loop
    // Line 154 in source code: post increment of local variable no. 6
    //                          post decrement of local variable no. 6
    // Line 155 in source code: changed conditional boundary
    //                          greater or equal to greater than
    //                          post increment of local variable no. 5
    //                          pre increment of local variable no. 5
    // Line 156 in source code: post increment of local variable no. 7
    //                          post decrement of local variable no. 7
    // Line 157 in source code: replacing inequalit with true
    // Line 158 in source code: post increment of local variable no. 3
    //                         post decrement of local variable no. 3
    // Line 162 in source code: post increment of local variable no. 3
    //                         post decrement of local variable no. 3
    // 
}