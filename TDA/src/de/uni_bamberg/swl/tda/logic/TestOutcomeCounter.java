package de.uni_bamberg.swl.tda.logic;

/**
 * Represents a counter for all {@link Outcome}s of a {@link TestRun}.
 * 
 * @author Nicolas Gross
 *
 */

public class TestOutcomeCounter {

	private final int TOTAL_TESTS;
	private final int EXECUTED_TESTS;
	private final int PASSED_TESTS;
	private final int FAILED_TESTS;

	/**
	 * Creates a new {@code TestOutcomeCounter}.
	 * 
	 * @param totalTests
	 *            the number of total tests. Mustn't be below one.
	 * @param executedTests
	 *            the number of executed tests. Mustn't be below zero.
	 * @param passedTests
	 *            the number of passed tests. Mustn't be below zero.
	 * @param failedTests
	 *            the number of failed tests. Mustn't be below zero.
	 * @throws TdaDataModelException
	 *             if any of the arguments is not valid.
	 */
	TestOutcomeCounter(int totalTests, int executedTests, int passedTests, int failedTests)
			throws TdaDataModelException {
		super();
		Validator.validateCounterNumbers(totalTests, executedTests, passedTests, failedTests);
		this.TOTAL_TESTS = totalTests;
		this.EXECUTED_TESTS = executedTests;
		this.PASSED_TESTS = passedTests;
		this.FAILED_TESTS = failedTests;
	}

	/**
	 * Getter for the total number of {@link UnitTest}s.
	 * 
	 * @return the total number of {@link UnitTest}s.
	 */
	public int getTotalTests() {
		return TOTAL_TESTS;
	}

	/**
	 * Getter for the number of executed {@link UnitTest}s.
	 * 
	 * @return the number of executed {@link UnitTest}s.
	 */
	public int getExecutedTests() {
		return EXECUTED_TESTS;
	}

	/**
	 * Getter for the number of passed {@link UnitTest}s.
	 * 
	 * @return the number of passed {@link UnitTest}s.
	 */
	public int getPassedTests() {
		return PASSED_TESTS;
	}

	/**
	 * Getter for the number of failed {@link UnitTest}s.
	 * 
	 * @return the number of failed {@link UnitTest}s.
	 */
	public int getFailedTests() {
		return FAILED_TESTS;
	}
}