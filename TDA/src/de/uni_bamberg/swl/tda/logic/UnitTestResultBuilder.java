package de.uni_bamberg.swl.tda.logic;

/**
 * A class that makes it possible to build an {@link UnitTestResult} step by
 * step.
 * 
 * @author Nicolas Gross
 *
 */

public class UnitTestResultBuilder {

	private String executionId;
	private String computerName;
	private String dataRowInfo;
	private String duration;
	private String startTime;
	private String endTime;
	private Outcome outcome;
	private String relativeResultsDirectory;
	private String testListId;
	private String testType;
	private String output;

	/**
	 * Creates a new {@code UnitTestResultBuilder}.
	 * 
	 */
	public UnitTestResultBuilder() {
		super();
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s execution ID.
	 * 
	 * @param executionId
	 *            the {@code UnitTestResultBuilder}'s execution id. Mustn't be
	 *            empty or null.
	 */
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s computer name.
	 * 
	 * @param computerName
	 *            the {@code UnitTestResultBuilder}'s computer name. Mustn't be
	 *            empty or null.
	 */
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s data row info.
	 * 
	 * @param dataRowInfo
	 *            the {@code UnitTestResultBuilder}'s data row info. Mustn't be
	 *            empty or null.
	 */
	public void setDataRowInfo(String dataRowInfo) {
		this.dataRowInfo = dataRowInfo;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s duration.
	 * 
	 * @param duration
	 *            the {@code UnitTestResultBuilder}'s duration. Mustn't be empty
	 *            or null and in the format "00:00:00.0111855".
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s start time.
	 * 
	 * @param startTime
	 *            the {@code UnitTestResultBuilder}'s start time. Mustn't be
	 *            empty or null and in the format
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s end time.
	 * 
	 * @param endTime
	 *            the {@code UnitTestResultBuilder}'s end time. Mustn't be empty
	 *            or null and in the format "2016-09-21T13:37:43.7071946+02:00".
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s outcome.
	 * 
	 * @param outcome
	 *            the {@code UnitTestResultBuilder}'s outcome. Mustn't be null.
	 */
	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s relative results directory.
	 * 
	 * @param relativeResultsDirectory
	 *            the {@code UnitTestResult}'s relative results directory.
	 *            Mustn't be empty or null.
	 */
	public void setRelativeResultsDirectory(String relativeResultsDirectory) {
		this.relativeResultsDirectory = relativeResultsDirectory;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s test list ID.
	 * 
	 * @param testListId
	 *            the {@code UnitTestResultBuilder}'s test list ID. Mustn't be
	 *            empty or null.
	 */
	public void setTestListId(String testListId) {
		this.testListId = testListId;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s test type.
	 * 
	 * @param testType
	 *            the {@code UnitTestResultBuilder}'s test type. Mustn't be
	 *            empty or null.
	 */
	public void setTestType(String testType) {
		this.testType = testType;
	}

	/**
	 * Sets the {@code UnitTestResultBuilder}'s output.
	 * 
	 * @param output
	 *            the {@code UnitTestResultBuilder}'s output. Musnt't be null.
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * Creates a new {@link UnitTestResult} with the set data.
	 * 
	 * @return the new {@link UnitTestResult}.
	 * @throws TdaDataModelException
	 *             if any of the parameters was not valid.
	 */
	public UnitTestResult create() throws TdaDataModelException {
		return new UnitTestResult(executionId, computerName, dataRowInfo, duration, startTime, endTime, outcome,
				relativeResultsDirectory, testListId, testType, output);
	}
}
