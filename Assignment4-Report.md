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
**Analysis:** 

# Report all the statistics and the mutation score for each test class

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
