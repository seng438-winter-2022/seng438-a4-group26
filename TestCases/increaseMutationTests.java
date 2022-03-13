package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class increaseMutationTests{
	private Range tester;
	
	
	@Before
	public void setUp() throws Exception {
		tester=new Range(2,6);
		
	}

	@After
	public void tearDown() throws Exception {
		tester=null;
	}

	/**
	 * Mutant increasing test case for hashCode. Calculates a hashCode IDENTICAL to the method itself and asserts (with infinitesimal difference) that computed matches return.
	 * Any difference shall be  caught mutation and thus increase the mutation score for this method.
	 */
	@Test
	public void increaseMutationHashCode(){
		//creating a hashcode the exact way the hashCode method does to test for 100% accuracy
		int expresult;
		long tempresult;
		tempresult = Double.doubleToLongBits(tester.getLowerBound());
		expresult = (int)(tempresult ^ (tempresult>>>32));
		tempresult = Double.doubleToLongBits(tester.getUpperBound());
		expresult = 29*expresult+(int)(tempresult^(tempresult>>>32));
		//asserting calculated hashCode above and hashCode() return exactly match - should catch many mutants now
		assertEquals(expresult,tester.hashCode(),1e-6);
	}
	
	
	
}
