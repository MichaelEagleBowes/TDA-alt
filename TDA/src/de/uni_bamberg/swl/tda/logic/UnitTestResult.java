package de.uni_bamberg.swl.tda.logic;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.ZonedDateTime;

/**
 * Represents the result of an {@link UnitTest}.
 * 
 * @author Nicolas Gross
 *
 */

public class UnitTestResult {

	private final String executionId;
	private final String computerName;
	private final String dataRowInfo;
	private final Duration duration;
	private final ZonedDateTime startTime;
	private final ZonedDateTime endTime;
	private final Outcome outcome;
	private final String relativeResultsDirectory;
	private final String testListId;
	private final String testType;
	private final String stdOut;
	private final String errorInfo;

	/**
	 * Creates a new {@code UnitTestResult}.
	 * 
	 * @param executionId
	 *            the {@code UnitTestResult}'s execution id. Mustn't be empty or
	 *            null.
	 * @param computerName
	 *            the {@code UnitTestResult}'s computer name. Mustn't be empty
	 *            or null.
	 * @param dataRowInfo
	 *            the {@code UnitTestResult}'s data row info. Mustn't be empty
	 *            or null.
	 * @param duration
	 *            the {@code UnitTestResult}'s duration. Mustn't be empty or
	 *            null and in the format "00:00:00.0111855".
	 * @param startTimed
	 *            the {@code UnitTestResult}'s start time. Mustn't be empty or
	 *            null and in the format "2016-09-21T13:37:43.7071946+02:00".
	 * @param endTime
	 *            the {@code UnitTestResult}'s end time. Mustn't be empty or
	 *            null and in the format "2016-09-21T13:37:43.7071946+02:00".
	 * @param outcome
	 *            the {@code UnitTestResult}'s outcome. Mustn't be null.
	 * @param relativeResultsDirectory
	 *            the {@code UnitTestResult}'s relative results directory.
	 *            Mustn't be empty or null.
	 * @param testListId
	 *            the {@code UnitTestResult}'s test list ID. Mustn't be empty or
	 *            null.
	 * @param testType
	 *            the {@code UnitTestResult}'s test type. Mustn't be empty or
	 *            null.
	 * @param stdOut
	 *            the {@code UnitTestResult}'s output on the standard output.
	 *            Musnt't be null.
	 * @param errorInfo
	 *            the {@code UnitTestResult}'s output on the error output.
	 *            Musnt't be null.
	 * @throws TdaDataModelException
	 *             if any of the parameters is not valid.
	 */
	public UnitTestResult(String executionId, String computerName, String dataRowInfo, String duration,
			String startTime, String endTime, Outcome outcome, String relativeResultsDirectory, String testListId,
			String testType, String stdOut, String errorInfo) throws TdaDataModelException {
		super();
		Validator.validateUnitTestResult(executionId, computerName, dataRowInfo, duration, endTime, outcome,
				relativeResultsDirectory, startTime, testListId, testType, stdOut, errorInfo);
		this.executionId = executionId;
		this.computerName = computerName;
		this.dataRowInfo = dataRowInfo;
		try {
			this.duration = Duration.parse("PT" + duration.replaceFirst(":", "H").replaceFirst(":", "M") + "S");
			this.startTime = ZonedDateTime.parse(startTime);
			this.endTime = ZonedDateTime.parse(endTime);
		} catch (DateTimeException e) {
			throw new TdaDataModelException(
					"A problem ocurred while parsing a time or the duration. Please check the format.", e);
		}
		this.outcome = outcome;
		this.relativeResultsDirectory = relativeResultsDirectory;
		this.testListId = testListId;
		this.testType = testType;
		this.stdOut = stdOut;
		this.errorInfo = errorInfo;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s execution ID.
	 * 
	 * @return the {@code UnitTestResult}'s execution ID.
	 */
	public String getExecutionId() {
		return executionId;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s computer name.
	 * 
	 * @return the {@code UnitTestResult}'s computer name.
	 */
	public String getComputerName() {
		return computerName;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s data row info.
	 * 
	 * @return the {@code UnitTestResult}'s data row info.
	 */
	public String getDataRowInfo() {
		return dataRowInfo;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s duration.
	 * 
	 * @return the {@code UnitTestResult}'s duration.
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s end time.
	 * 
	 * @return the {@code UnitTestResult}'s end time.
	 */
	public ZonedDateTime getEndTime() {
		return endTime;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s outcome.
	 * 
	 * @return the {@code UnitTestResult}'s outcome.
	 */
	public Outcome getOutcome() {
		return outcome;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s relative results directory.
	 * 
	 * @return the {@code UnitTestResult}'s relative results directory.
	 */
	public String getRelativeResultsDirectory() {
		return relativeResultsDirectory;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s start time.
	 * 
	 * @return the {@code UnitTestResult}'s start time.
	 */
	public ZonedDateTime getStartTime() {
		return startTime;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s test list ID.
	 * 
	 * @return the {@code UnitTestResult}'s test list ID.
	 */
	public String getTestListId() {
		return testListId;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s test type.
	 * 
	 * @return the {@code UnitTestResult}'s test type.
	 */
	public String getTestType() {
		return testType;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s output on the standard output.
	 * 
	 * @return the {@code UnitTestResult}'s output on the standard output.
	 */
	public String getStdOut() {
		return stdOut;
	}

	/**
	 * Getter for the {@code UnitTestResult}'s output on the error ouptut.
	 * 
	 * @return the {@code UnitTestResult}'s output on the error output.
	 */
	public String getErrorInfo() {
		return errorInfo;
	}
}