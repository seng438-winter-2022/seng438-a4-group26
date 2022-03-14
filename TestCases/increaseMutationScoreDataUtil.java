package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.chart.util.ParamChecks;
import org.jfree.data.DataUtilities;
//import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class increaseMutationScoreDataUtil{
	//private DataUtilities test;
	private Mockery mocking;
	Values2D values;
	
	
	@Before
	public void setUp() throws Exception {
		//test=new DataUtilities();
		mocking = new Mockery();
		values=mocking.mock(Values2D.class);
	}

	@After
	public void tearDown() throws Exception {
		//test=null;
	}

	/**
	 * Attempt to catch mutation where paramchecks.nullnotpermitted is removed.
	 */
	@Test (expected = Exception.class)
	public void increaseCreateNumberArray2D(){
		double[][] dataIn = null;
		Number[][] recv = DataUtilities.createNumberArray2D(dataIn);
		assertEquals(recv, null);
		//ParamChecks.nullNotPermitted(dataIn, "dataIn");
	}
	
	/**
	 * test to increase createnumberarray2d mutation score. Specifically to kill the mutant
	 * where the for loop in createnumberarray2d is mutated to an infinite loop.
	 * To kill this mutant, the test was designed to quickly timeout and throw a timeout
	 * exception when the for loop goes beyond 100 ms, thus killing the infinite loop mutant
	 * @throws InterruptedException when timeout occurs
	 */
	@Test(timeout=100)
	public void increaseCreateNumberArray2DTwo() throws InterruptedException {
		double [][] data = {{1.0,2.0,3.0,4.0,5.0},{7.0,8.5,9.5,10.0}};
		Number [][] recevied = DataUtilities.createNumberArray2D(data);
		assertEquals(data, recevied);
	}
	
	/**
	 * Test case for calculateRowTotal to kill the mutant where "if(n!=null)" is changed to 
	 * "if(true)". 
	 * To catch this mutation, we make a test case where n (a cell value within the row we're
	 * calculating) is in fact equal to null, and thus should never reach inside of the aforementioned
	 * if statement. Since the mutant will (if(true)), the computed value will differ and thus
	 * the test case will fail, and the mutant killed.
	 */
	@Test
	public void nullCell()
	{
		
		
		mocking.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(1));
				one(values).getRowCount();
				will(returnValue(1));
				one(values).getValue(0, 0);
				will(returnValue(null));
			}
		});
		int[] rows = {0};
		double calculateMe = DataUtilities.calculateRowTotal(values, 0, rows);
		
		assertEquals(0,calculateMe,0);
	}
	
	
	
}
