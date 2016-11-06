package de.uni_bamberg.swl.tda.logic;

import java.util.List;

/**
 * Represents a class which is tested by a number of {@link UnitTest}s.
 * 
 * @author Nicolas Gross
 *
 */

public class TestedClass {

	private final String NAME;
	private final List<UnitTest> TEST_LIST;
	private final double FAILURE_PERCENTAGE;

	/**
	 * Creates a new {@code TestedClass}.
	 * 
	 * @param name
	 *            the {@code TestedClass}' name. Mustn't be null or empty.
	 * @param testList
	 *            the {@code TestedClass}' list of {@link UnitTest}s. Mustn't be
	 *            null or empty.
	 * @throws TdaDataModelException
	 *             if any of the arguments is not valid.
	 */
	public TestedClass(String name, List<UnitTest> testList) throws TdaDataModelException {
		super();
		Validator.validateTestedClass(name, testList);
		NAME = name;
		TEST_LIST = testList;
		FAILURE_PERCENTAGE = calcFailurePercentage();
	}

	/**
	 * Calculator for the failure percentage of the {@code TestedClass}.
	 * 
	 * @return the failure percentage of the {@code TestedClass}.
	 */
	private double calcFailurePercentage() {
		double failed = 0.0;
		double total = TEST_LIST.size();

		for (UnitTest unitTest : TEST_LIST) {
			if (unitTest.getOutcome() == Outcome.FAILED) {
				failed++;
			}
		}

		return Math.round((failed / total) * 10000.0) / 100.0;
	}

	/**
	 * Getter for the {@code TestedClass}' name.
	 * 
	 * @return the {@code TestedClass}' name.
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * Getter for the {@code TestedClass}' list of {@link UnitTest}s.
	 * 
	 * @return the {@code TestedClass}' list of {@link UnitTest}s.
	 */
	public List<UnitTest> getTestList() {
		return TEST_LIST;
	}

	/**
	 * Getter for the {@code TestedClass}' failure percentage.
	 * 
	 * @return the {@code TestedClass}' failure percentage rounded to two
	 *         decimal places.
	 */
	public double getFailurePercentage() {
		return FAILURE_PERCENTAGE;
	}
}
