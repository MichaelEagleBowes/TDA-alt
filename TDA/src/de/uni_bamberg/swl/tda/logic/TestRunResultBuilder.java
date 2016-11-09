package de.uni_bamberg.swl.tda.logic;

/**
 * A class that makes it possible to build an {@link TestRunResult} step by
 * step.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRunResultBuilder {

	private Outcome outcome;
	private int aborted;
	private int completed;
	private int disconnected;
	private int error;
	private int executed;
	private int failed;
	private int inProgress;
	private int inconclusive;
	private int notExecuted;
	private int notRunnable;
	private int passed;
	private int passedButRunAborted;
	private int pending;
	private int timeout;
	private int total;
	private int warning;

	/**
	 * Creates new {@code TestRunResultBuilder}.
	 * 
	 */
	public TestRunResultBuilder() {
		super();
	}

	/**
	 * Sets the outcome of the {@code TestRunBuilder}.
	 * 
	 * @param outcome
	 *            the outcome of the {@code TestRunBuilder}. Mustn't be null.
	 */
	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

	/**
	 * Sets the number of aborted tests.
	 * 
	 * @param outcome
	 *            the number of aborted tests. Mustn't be below zero.
	 */
	public void setAborted(int aborted) {
		this.aborted = aborted;
	}

	/**
	 * Sets the number of completed tests.
	 * 
	 * @param outcome
	 *            the number of completed tests. Mustn't be below zero.
	 */
	public void setCompleted(int completed) {
		this.completed = completed;
	}

	/**
	 * Sets the number of disconnected tests.
	 * 
	 * @param outcome
	 *            the number of disconnected tests. Mustn't be below zero.
	 */
	public void setDisconnected(int disconnected) {
		this.disconnected = disconnected;
	}

	/**
	 * Sets the number of tests with an error.
	 * 
	 * @param outcome
	 *            the number of tests with an error. Mustn't be below zero.
	 */
	public void setError(int error) {
		this.error = error;
	}

	/**
	 * Sets the number of executed tests.
	 * 
	 * @param outcome
	 *            the number of executed tests. Mustn't be below zero.
	 */
	public void setExecuted(int executed) {
		this.executed = executed;
	}

	/**
	 * Sets the number of failed tests.
	 * 
	 * @param outcome
	 *            the number of failed tests. Mustn't be below zero.
	 */
	public void setFailed(int failed) {
		this.failed = failed;
	}

	/**
	 * Sets the number of tests in progress.
	 * 
	 * @param outcome
	 *            the number of tests in progress. Mustn't be below zero.
	 */
	public void setInProgress(int inProgress) {
		this.inProgress = inProgress;
	}

	/**
	 * Sets the number of inconclusive tests.
	 * 
	 * @param outcome
	 *            the number of inconclusive tests. Mustn't be below zero.
	 */
	public void setInconclusive(int inconclusive) {
		this.inconclusive = inconclusive;
	}

	/**
	 * Sets the number of not executed tests.
	 * 
	 * @param outcome
	 *            the number of not executed tests. Mustn't be below zero.
	 */
	public void setNotExecuted(int notExecuted) {
		this.notExecuted = notExecuted;
	}

	/**
	 * Sets the number of not runnable tests.
	 * 
	 * @param outcome
	 *            the number of not runnable tests. Mustn't be below zero.
	 */
	public void setNotRunnable(int notRunnable) {
		this.notRunnable = notRunnable;
	}

	/**
	 * Sets the number of passed tests.
	 * 
	 * @param outcome
	 *            the number of passed tests. Mustn't be below zero.
	 */
	public void setPassed(int passed) {
		this.passed = passed;
	}

	/**
	 * Sets the number of passed tests, but run was aborted.
	 * 
	 * @param outcome
	 *            the number of passed tests, but run was aborted. Mustn't be
	 *            below zero.
	 */
	public void setPassedButRunAborted(int passedButRunAborted) {
		this.passedButRunAborted = passedButRunAborted;
	}

	/**
	 * Sets the number of pending tests.
	 * 
	 * @param outcome
	 *            the number of pending tests. Mustn't be below zero.
	 */
	public void setPending(int pending) {
		this.pending = pending;
	}

	/**
	 * Sets the number of tests with a timeout.
	 * 
	 * @param outcome
	 *            the number of tests with a timeout. Mustn't be below zero.
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * Sets the number of total tests.
	 * 
	 * @param total
	 *            the number of total tests. Mustn't be below one.
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	public void setWarning(int warning) {
		this.warning = warning;
	}

	/**
	 * Creates a new {@link TestRunResult} with the set data.
	 * 
	 * @return the new {@link TestRunResult}.
	 * @throws TdaDataModelException
	 *             if any of the parameters was not valid.
	 */
	public TestRunResult create() throws TdaDataModelException {
		return new TestRunResult(outcome, aborted, completed, disconnected, error, executed, failed, inProgress,
				inconclusive, notExecuted, notRunnable, passed, passedButRunAborted, pending, timeout, total, warning);
	}
}
