package de.uni_bamberg.swl.tda.logic;

import java.util.List;

/**
 * Validation class for the logic package.
 * 
 * @author Nicolas Gross
 *
 */

class Validator {

	static void validateUnitTest(String id, String name) throws TdaDataModelException {
		if (id == null || name == null || id.isEmpty() || name.isEmpty()) {
			throw new TdaDataModelException("The ID and name of an UnitTest can't be null or left empty.");
		}
	}

	static void validateTestedClass(String name, List<UnitTest> testList) throws TdaDataModelException {
		if (name == null || testList == null || name.isEmpty() || testList.isEmpty()) {
			throw new TdaDataModelException("The name and test list of a TestedClass can't be null or left empty.");
		}
	}

	static void validateTestRun(String id, String creationDate, Outcome outcome, List<TestedClass> classList)
			throws TdaDataModelException {
		if (id == null || creationDate == null || outcome == null || classList == null || id.isEmpty()
				|| creationDate.isEmpty() || classList.isEmpty()) {
			throw new TdaDataModelException("The arguments can't be null or left empty.");
		}
	}

	static void validateCounterNumbers(int totalTests, int executedTests, int passedTests, int failedTests)
			throws TdaDataModelException {
		if (totalTests < 1 || executedTests < 0 || passedTests < 0 || failedTests < 0) {
			throw new TdaDataModelException(
					"The total number of tests has to be greater than 0 and the other numbers mustn't be below zero.");
		}
	}
}
