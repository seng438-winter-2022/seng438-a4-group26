**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group 26         |          |                |
| ---------------- | -------- | -------------- |
| Liana Goodman    | 30089196 | LianaBG        |
| Amir Abdrakmanov | 30085827 | aabdrakmanov   |
| Jared Lundy      | 30086687 | jared840       |
| Jordan Lundy     | 30086686 | jordan427-prog |

# Introduction
This lab explores mutation and GUI testing to familiarize ourselves with the processes involved with these tests. We also get the opportunity to explore testing tools.

Mutation testing is when the SUT is modified in order to assess the quality of test cases and help improve them. We are using `Pitest` on our java code from previous labs to inject faults and learn to interpret mutation scores.

GUI testing is when a GUI is tested through clicks and inputs which cannot be modeled like regular JUnit tests. We will use Selenium to record and replay test cases developed for the Sportcheck page, Walmart page, or Best Buy page. We will also explore and compare the `Sikulix` tool as an alternative.
# Analysis of 10 Mutants of the Range class 

## Mutant #1
**Method tested:** public static Range shift(Range base, double delta, boolean allowZeroCrossing) <br />
**Mutant Produced:** removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted <br />
**Survived or Killed:** Killed  <br />
**Test class:** shiftTest.java  <br />
**How it was killed or not by test case:** In shiftTest.java, the test case 'nullTest()', which supplied a null Range argument
effectively failed once this mutant was introduced by PIT, indicating that the mutant was killed by this test case.
Since this test case supplies a null Range argument, the test case expects an exception to be thrown. However,
once the ParamChecks::nulNotPermitted is removed, the illegalArgument exception that would've immediately been thrown 
is no longer thrown, thus the test case fails and the mutant is killed.

## Mutant #2
**Method tested:** public static Range shift(Range base, double delta, boolean allowZeroCrossing  <br />
**Mutant Produced:** negated conditional (line 366) <br />
**Survived or Killed:** Killed  <br />
**Test class:** shiftTest.java  <br />
**How it was killed or not by test case:** In shiftTest.java, the test case allowZeroFalse() fails due to the mutant, thus
	killing the mutant. Since the if(allowZeroCrossing) statement in the original shift method is negated, the method
	treats the test method as if allowZeroCrossing is true (despite it being false in the test case). Thus, the range
	is shifted -5 units and past zero. The test case expects the result to be zero since allowZeroCrossing is false, 
	but the mutant treats allowZeroCrossing as true and the actual result is -2. Thus, this test case kills the mutant.

## Mutant #3
**Method tested:** public static Range shift(Range base, double delta, boolean allowZeroCrossing  <br />
**Mutant Produced:** Replaced double addition with subtraction <br />
**Survived or Killed:** Killed <br />
**Test class:** shiftTest.java <br />
**How it was killed or not by test case:** All test cases in shiftTest that have allowZeroCrossing as true and expect a 
	numerical return fail once this mutant is introduced, thus killing the mutant. Since it originally returned
	a new Range with lower bound=original+delta and upper bound=lower+delta, the Range boundaries are now completely
	different numerical values since they are mutated to original-delta each. Thus, the assertion that retrieves the 
	boundaries in the test cases fail since they expect original+delta. Thus, the mutant is killed.
  
 ## Mutant #4
 **Method tested:** public boolean contains(double value) <br />
**Mutant Produced:** removed conditional - replaced comparison check with false <br />
**Survived or Killed:** Survived <br />
**Test class:**  <br />
**How it was killed or not by test case:** Mutating the contains method to immediately return false does not create any failed
	test cases, indicating that any test case that calls contains only calls it when it is expected to return false. 
	Thus, an easy test case to include to increase the mutation score is to create a test case that expects a true return 
	from contains.
  
 ## Mutant #5
 **Mutation:** removed conditional - replaced equality check with false -> killed <br />
**Location:** shift <br />
**Killed by:** org.jfree.data.test.shiftTest.allValidParams <br />
**Analysis:** allValidParams effectively killed the mutant where the if(allowZeroCrossing) is replaced to if(false). Since 
	allowZero is true in the allValidParams test case, the mutated case will go into the else stataement when it shouldn't
 \	have. Thus, the mutation treats it as if it cannot cross zero and thus returns 0, although the test case expected
	that it should've crossed zero to -4 since allowZero is true for the test case.
  
 ## Mutant #6
**Mutation:** Negated conditional (line 158) <br />
**Location:** intersects <br />
**Killed by:** org.jfree.data.test.intersectsTesting.intersectsNoOverLap <br />
**Analysis:** The test case intersectsNoOverlap asserts that the call to intersects is false, since the Range of one was (-5,-2)
and the other range tested was (3,8). Obviously, these two ranges do not overlap and thus the asserfalse should pass without mutation.
However, the mutation negated the conditional in intersects, so when the intersects() would normally return false, it now returns true.
Thus, the test case will now fail and thus the mutation is killed.

## Mutant #7
**Mutation:** Replaced double subtraction with addition → KILLED (line 123) <br />
**Location:** getLength <br />
**Killed by:** org.jfree.data.test.RangeGetLengthTest.testBothNegative <br />
**Analysis:** In this mutation, the range boundary length computation is altered from upper-lower to upper+bound. Thus, the test 
case testBothNegative fails and kills the mutant, as -3.25-(-6.75) becomes -3.25+6.75, and the assert in the test case fails since
the incorrect length is now computed and returned.

## Mutant #8
**Mutation:** replaced return of double value with -(x + 1) for org/jfree/data/Range::getLowerBound → KILLED
**Location:** getLowerBound <br />
**Killed by:** org.jfree.data.test.getLowerBoundTest.testNegativeNumber <br />
**Analysis:** This mutation takes the minimum value for the range, and then chnages it to -(min+1). The mutaton was
killed, therefore the test case failed. This fails because the assert statement looks for the min value, but instead
has -(min+1). Therefore, the statement is false, and the assert fails fails, and the mutation is killed. 

## Mutant #9
**Mutation:** removed conditional - replaced comparison check with true → SURVIVED <br />
**Location:** intersects <br />
**Killed by:** none <br />
**Analysis:** TThis mutation returns true or false depending on if two ranges intersect or not. In this mutation, the lofical return statement was converted simply to true. The mutation survived, which means the test cases passed. This 
means that the test case only ever returned for logical statements resulting in true. Thherefore, test cases where
the return should be false should be implemented to increase mutation score.

## Mutant #10
**Mutation:**  Substituted 2.0 with 1.0 → KILLED <br />
**Location:** getCentralValue <br />
**Killed by:** org.jfree.data.test.RangeTest.org.jfree.data.test.RangeTest <br />
**Analysis:** This mutation changes thr division by 2 to division by 1. This will not not give a proper central value, 
but instead, just add the lower and upper value. This mutation was killed, and so the test case failed. This expects
a central value, but instead you get a summation of the bounds.

# Report all the statistics and the mutation score for each test class

## DataUtilites test classes

### `DataUtilitesTestEqual`
originally this test class had a mutation score of 91.17% after improvements to the test suite a new mutation score of 94.12% was attained. This was done by including 3 new test cases, which were:

`testLengthsUnequalButSwitched` - A test changing the order of given arrays  
`testEveryOtherSame` - A test where every other array in a and b was equal  
`testCompletelyDifferent` - A test where no element of any array was equal  

This test class was testing the `equal` function in DataUtilites, this function incorporates a loop which means that a mutation of '<' to '!=' in the loop's condition are effectively the same in this implementation causing this mutation to live. Additionally, PITest mutated the line `return true;` to "Substituted 1 with -1" this mutation does not make sense and is a mutation that was not detected by the test case.

### `TestDataUtilitesCumulativePercentages`
Originally, this test class had a mutation score of 78.62%, after improving the test class, a new mutation score of 95.34% was attained. This was done by updating`testSequentialList` and `DataUtilities` itself to align with the documentation. The few surviving mutations are either replacements of '<' to '!=' in a array loop or a post increment/decrement of a local variable on a return line. Both of these mutations within the context of the implmentation do not produce any failures, thus the mutations live.

### `CreateNumberArray2D`
Before adding new test cases, the mutation score for this class was 80%. One of the two mutants that survived was changing the for
loop increment to no increment, creating an infinite loop. This mutant timed out but was never killed by any test case. Thus, 
a test case was designed that aimed to timeout after a small time (100 ms) to ensure that an infinite loop was caught and the
test case would fail. This would kill this mutant. Therefore, this test case was added:

`increaseCreateNumberArray2DTwo()`:  test to increase createnumberarray2d mutation score. Specifically to kill the mutant where
the for loop in createnumberarray2d is mutated to an infinite loop. To kill this mutant, the test was designed to quickly timeout
and throw a timeout exception when the for loop goes beyond 100 ms, thus killing the infinite loop mutant.
@throws InterruptedException when timeout occurs.

After this added test case, the mutation score was increased from **80% to 90%**.
The remaining 10% is from the removal of the ParamChecks.NullNotPermitted() mutation, which was unable to be killed with any 
additional test cases.

### `CalculateRowTotal(Values2D, int, int[])`
Initially, the mutation score for this was 90.47%. Two mutations survived. One surviving mutation was when the if(n!=null)
was changed to if(true), and the other was removing the ParamChecks.NullNotPermitted() call. 
The ParamChecks call was not easily killed by an additional test case, and thus was not killed by any new test cases.
The if(n!=null)->if(true) was easily killed, however. Since all the exisiting test cases never had a cell that contained
a null value in them (n), this if statement was always evaluated to true anyways. Thus, to kill the mutant a new test case had
to be devised where n==null at some point, and thus the test case would fail. The created test case was:
`nullCell()` :Test case for calculateRowTotal to kill the mutant where "if(n!=null)" is changed to "if(true)". 
To catch this mutation, we make a test case where n (a cell value within the row we're calculating) is in fact equal to null, and 
thus should never reach inside of the aforementioned if statement. Since the mutant will (if(true)), the computed value will 
differ and thus the test case will fail, and the mutant killed.

Adding this test case increased the mutation score from **90.47% to 95.24%.**

## Range test classes

### `RangeCombineTest`
Originally, this test class had a mutation score of 78.78%, after improving the test class, a new mutation score of 87.87% was attained. Three test cases were added:

`testLargeR2smallR1` - A test for where R2 is a large range that has negative values and R1 is entirely positive  
`testBothRangesHaveNegativeLowers` - A test where both R1 and R2 have a negative lower bound  
`testBothRangesHaveNegativeUppers` - A test where both ranges are fully negative  

This test class failed to detect four mutations out of 33. However these mutations are all post increment/decrement to local variables on return lines. This means that these mutations would have no effect on the correct operation of the function. 

### `RangeTestExpandToInclude`
Originally, this test case had a mutation score of 83.58%, after improving the test class, a new mutation score of 85.07% was attained. five test cases were added:

`valueOnLowerBound` - the target value is set to the lower bound of the range  
`valueNegativeNominal` - a non zero negative value is used  
`valueOnUpperBound` - the target value is set to the upper bound of the range  
`valuePositiveNomial` - a non zero positive value is used  
`NaNComparison` - both the range and value have a Double.NaN forcing a comparison of NaN  

This test class still fails to detect post increment/decrement of local variables on a return line. Additionally, the implementation of the `expandToInclude` function in `Range` allows for the changes '<' to '=<'and '>' to '>=' without changing expected outcomes. 

### `RangeTestIntersectsDouble`
Originally, this test class had a mutation score of 63.20%, after improving the test class, a new mutation score of 89.62% was attained. five test cases were added:

`PointOnLower` - the argument range is a point equal to the lower bound of the calling range  
`PointOnUpper` - the argument range is a point equal to the upper bound of the calling range  
`PointInRange` - the argument range is a point in the calling range  
`lowerUnchanged` - test for verifying that `intersects(double, double)` does not change the lower bound of the calling range  
`upperUnchanged` - test for verifying that `intersects(double, double)` does not change the upper bound of the calling range  

The test class still fails to detect mutations where a local variable is post incremented/decremented on a return line and the "Substituted 1 with -1" mutation on return lines.

### `RangeTestScale`
Originally, this test class had a mutation score of 76%, after improving the test class, a new mutation score of 96% was attained. Two new test cases were added:

`testScaleByPositiveWhereRangeisLarge` - Scaling a very large range by a value greater than 1  
`testScaleByZero` - Scale a given range by a factor of 0  

additionally, testScaleByNegative was modified to better catch mutants. The only mutants not killed by these changes were again mutantations on a post increment/decrement of a local variable on a return line. 

### `RangeTestShiftDouble`
This test class has a mutation score of 85.14%, no improvements could be made as the only mutations that survived were post increment/decrements of local variables on return lines. 

### `HashCode`
Before adding any additional test cases, the mutation score for the hashCode() method was **8.333%**, indicating a poor mutation 
performance for the existing hashCode tests. Looking at the mutants generated by the tool, it was clear that all the mutants
were based on manipulating the computationl values of the hashcode itself. Thus, one large test case was added:

`increaseMutationHashCode()` : Mutant increasing test case for hashCode. Calculates a hashCode IDENTICAL to the method itself and
asserts (with infinitesimal difference) that computed matches return exactly. Any difference shall be a caught mutation and thus 
increase the mutation score for this method.

After adding this test case, the hashCode() mutation score increased to **100%**.

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed

# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
