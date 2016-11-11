package de.uni_bamberg.swl.tda.logic;

import java.util.List;

/**
 * Validation class for the logic package.
 * 
 * @author Nicolas Gross
 *
 */

class Validator {

	static void validateUnitTest(String id, String name, String storage, String adapterTypeName, String codeBase,
			UnitTestResult result) throws TdaDataModelException {
		if (id == null || name == null || storage == null || adapterTypeName == null || codeBase == null
				|| result == null) {
			throw new TdaDataModelException("The parameters of an UnitTest mustn't be null.");
		} else if (id.isEmpty() || name.isEmpty() || storage.isEmpty() || adapterTypeName.isEmpty()
				|| codeBase.isEmpty()) {
			throw new TdaDataModelException("The parameters of an UnitTest mustn't be empty.");
		}
	}

	static void validateUnitTestResult(String executionId, String computerName, String dataRowInfo, String duration,
			String endTime, Outcome outcome, String relativeResultsDirectory, String startTime, String testListId,
			String testType, String stdOut, String errorInfo) throws TdaDataModelException {
		if (executionId == null || computerName == null || dataRowInfo == null || duration == null || endTime == null
				|| outcome == null || relativeResultsDirectory == null || startTime == null || testListId == null
				|| testType == null || stdOut == null || errorInfo == null) {
			throw new TdaDataModelException("The parameters of an UnitTestResult mustn't be null.");
		} else if (executionId.isEmpty() || computerName.isEmpty() || dataRowInfo.isEmpty()
				|| relativeResultsDirectory.isEmpty() || testListId.isEmpty() || testType.isEmpty()) {
			throw new TdaDataModelException("The parameters of an UnitTestResult mustn't be empty.");
		}

	}

	static void validateTestedClass(String name, List<UnitTest> testList) throws TdaDataModelException {
		if (name == null || testList == null) {
			throw new TdaDataModelException("The name and test list of a TestedClass mustn't be null.");
		} else if (name.isEmpty() || testList.isEmpty()) {
			throw new TdaDataModelException("The name and test list of a TestedClass mustn't be left empty.");
		}
	}

	static void validateTestRunResult(Outcome outcome, int aborted, int completed, int disconnected, int error,
			int executed, int failed, int inProgress, int inconclusive, int notExecuted, int notRunnable, int passed,
			int passedButRunAborted, int pending, int timeout, int total, int warning) throws TdaDataModelException {
		if (outcome == null) {
			throw new TdaDataModelException("The outcome of a TestRunResult mustn't be null.");
		} else if (total < 1 || aborted < 0 || completed < 0 || disconnected < 0 || error < 0 || executed < 0
				|| failed < 0 || inProgress < 0 || inconclusive < 0 || notExecuted < 0 || notRunnable < 0 || passed < 0
				|| passedButRunAborted < 0 || pending < 0 || timeout < 0 || warning < 0) {
			throw new TdaDataModelException(
					"The parameters of a TestRunResult mustn't be below zero. The total number of tests mustn't be below 1.");
		}
	}

	static void validateTestRunSetting(String id, String name, String runDeploymentRoot,
			boolean useDefaultDeploymentRoot, String userDeploymentRoot, String agentRuleName)
			throws TdaDataModelException {
		if (id == null || name == null || runDeploymentRoot == null || userDeploymentRoot == null
				|| agentRuleName == null) {
			throw new TdaDataModelException("The parameters of a TestRunSetting mustn't be null.");
		} else if (id.isEmpty() || name.isEmpty() || runDeploymentRoot.isEmpty() || userDeploymentRoot.isEmpty()
				|| agentRuleName.isEmpty()) {
			throw new TdaDataModelException("The parameters of an TestRunSetting mustn't be empty.");
		}
	}

	static void validateTestRun(String xmlns, String id, String name, String runUser, String creationDate,
			String finishDate, String queuingDate, String startDate, List<TestedClass> classList,
			TestRunSetting setting, TestRunResult result) throws TdaDataModelException {
		if (xmlns == null || id == null || name == null || runUser == null || creationDate == null || finishDate == null
				|| queuingDate == null || startDate == null || classList == null || setting == null || result == null) {
			throw new TdaDataModelException("The parameters of a TestRun mustn't be null.");
		} else if (xmlns.isEmpty() || id.isEmpty() || name.isEmpty() || runUser.isEmpty() || creationDate.isEmpty()
				|| finishDate.isEmpty() || queuingDate.isEmpty() || startDate.isEmpty() || classList.isEmpty()) {
			throw new TdaDataModelException("The parameters of a TestRun mustn't be empty.");
		}
	}
}
