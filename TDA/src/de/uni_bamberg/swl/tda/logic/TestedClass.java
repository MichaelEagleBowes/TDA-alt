package de.uni_bamberg.swl.tda.logic;

import java.util.List;

/**
 * Represents a class which is tested by a number of {@link UnitTest}s.
 * 
 * @author Nicolas Gross
 *
 */

public class TestedClass {

	private final String name;
	private final List<UnitTest> testList;
	private final double failurePercentage;

	/**
	 * Creates a new {@code TestedClass}.
	 * 
	 * @param name
	 *            the {@code TestedClass}' name. Mustn't be null or empty.
	 * @param testList
	 *            the {@code TestedClass}' list of {@link UnitTest}s. Mustn't be
	 *            null or empty.
	 * @throws TdaDataModelException
	 *             if any of the parameters is not valid.
	 */
	public TestedClass(String name, List<UnitTest> testList) throws TdaDataModelException {
		super();
		Validator.validateTestedClass(name, testList);
		this.name = name;
		this.testList = testList;
		this.failurePercentage = calcFailurePercentage();
	}

	/**
	 * Calculator for the failure percentage of the {@code TestedClass}.
	 * 
	 * @return the failure percentage of the {@code TestedClass}.
	 */
	private double calcFailurePercentage() {
		double failed = 0.0;
		double total = testList.size();

		for (UnitTest unitTest : testList) {
			if (unitTest.getResult().getOutcome() == Outcome.FAILED) {
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
		return name;
	}

	/**
	 * Getter for the {@code TestedClass}' list of {@link UnitTest}s.
	 * 
	 * @return the {@code TestedClass}' list of {@link UnitTest}s.
	 */
	public List<UnitTest> getTestList() {
		return testList;
	}

	/**
	 * Getter for the {@code TestedClass}' failure percentage.
	 * 
	 * @return the {@code TestedClass}' failure percentage rounded to two
	 *         decimal places.
	 */
	public double getFailurePercentage() {
		return failurePercentage;
	}
}
