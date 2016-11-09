package de.uni_bamberg.swl.tda.logic;

/**
 * Represents the outcome of an {@link UnitTest} or {@link TestRun}.
 * 
 * @author Nicolas Gross
 *
 */

public enum Outcome {

	/**
	 * {@link UnitTest} or {@link TestRun} was successful.
	 * 
	 */
	PASSED,

	/**
	 * {@link UnitTest} or {@link TestRun} failed.
	 * 
	 */
	FAILED
}
