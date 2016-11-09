package de.uni_bamberg.swl.tda.logic;

/**
 * Represents the result of a {@link TestRun}.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRunResult {

	private final Outcome outcome;
	private final int aborted;
	private final int completed;
	private final int disconnected;
	private final int error;
	private final int executed;
	private final int failed;
	private final int inProgress;
	private final int inconclusive;
	private final int notExecuted;
	private final int notRunnable;
	private final int passed;
	private final int passedButRunAborted;
	private final int pending;
	private final int timeout;
	private final int total;
	private final int warning;

	/**
	 * Creates a new {@code TestOutcomeCounter}.
	 * 
	 * @param outcome
	 *            the outcome of the {@link TestRun}. Mustn't be null.
	 * @param aborted
	 *            the number of aborted tests. Mustn't be below zero.
	 * @param completed
	 *            the number of completed tests. Mustn't be below zero.
	 * @param disconnected
	 *            the number of disconnected tests. Mustn't be below zero.
	 * @param error
	 *            the number of tests with an error. Mustn't be below zero.
	 * @param executed
	 *            the number of executed tests. Mustn't be below zero.
	 * @param failed
	 *            the number of failed tests. Mustn't be below zero.
	 * @param inProgress
	 *            the number of tests in progress. Mustn't be below zero.
	 * @param inconclusive
	 *            the number of inconclusive tests. Mustn't be below zero.
	 * @param notExecuted
	 *            the number of not executed tests. Mustn't be below zero.
	 * @param notRunnable
	 *            the number of not runnable tests. Mustn't be below zero.
	 * @param passed
	 *            the number of passed tests. Mustn't be below zero.
	 * @param passedButRunAborted
	 *            the number of passed tests with aborted run. Mustn't be below
	 *            zero.
	 * @param pending
	 *            the number of pending tests. Mustn't be below zero.
	 * @param timeout
	 *            the number of tests with a timeout. Mustn't be below zero.
	 * @param total
	 *            the number of total tests. Mustn't be below one.
	 * @param warning
	 *            the number of tests with a warning. Mustn't be below zero.
	 * @throws TdaDataModelException
	 *             if any of the parameters is not valid.
	 */
	public TestRunResult(Outcome outcome, int aborted, int completed, int disconnected, int error, int executed,
			int failed, int inProgress, int inconclusive, int notExecuted, int notRunnable, int passed,
			int passedButRunAborted, int pending, int timeout, int total, int warning) throws TdaDataModelException {
		super();
		Validator.validateTestRunResult(outcome, aborted, completed, disconnected, error, executed, failed, inProgress,
				inconclusive, notExecuted, notRunnable, passed, passedButRunAborted, pending, timeout, total, warning);
		this.outcome = outcome;
		this.aborted = aborted;
		this.completed = completed;
		this.disconnected = disconnected;
		this.error = error;
		this.executed = executed;
		this.failed = failed;
		this.inProgress = inProgress;
		this.inconclusive = inconclusive;
		this.notExecuted = notExecuted;
		this.notRunnable = notRunnable;
		this.passed = passed;
		this.passedButRunAborted = passedButRunAborted;
		this.pending = pending;
		this.timeout = timeout;
		this.total = total;
		this.warning = warning;
	}

	/**
	 * Getter for the {@link TestRun}'s total number of {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s total number of {@link UnitTest}s.
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Getter for the {@link TestRun}'s number of executed {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of executed {@link UnitTest}s.
	 */
	public int getExecuted() {
		return executed;
	}

	/**
	 * Getter for the {@link TestRun}'s number of passed {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of passed {@link UnitTest}s.
	 */
	public int getPassed() {
		return passed;
	}

	/**
	 * Getter for the {@link TestRun}'s number of failed {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of failed {@link UnitTest}s.
	 */
	public int getFailed() {
		return failed;
	}

	/**
	 * Getter for the overall outcome of the {@link TestRun}.
	 * 
	 * @return the overall outcome of the {@link TestRun}.
	 */
	public Outcome getOutcome() {
		return outcome;
	}

	/**
	 * Getter for the {@link TestRun}'s number of aborted {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of aborted {@link UnitTest}s.
	 */
	public int getAborted() {
		return aborted;
	}

	/**
	 * Getter for the {@link TestRun}'s number of completed {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of completed {@link UnitTest}s.
	 */
	public int getCompleted() {
		return completed;
	}

	/**
	 * Getter for the {@link TestRun}'s number of disconnected
	 * {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of disconnected {@link UnitTest}s.
	 */
	public int getDisconnected() {
		return disconnected;
	}

	/**
	 * Getter for the {@link TestRun}'s number of {@link UnitTest}s with an
	 * error.
	 * 
	 * @return the {@link TestRun}'s number of {@link UnitTest}s with an error.
	 */
	public int getError() {
		return error;
	}

	/**
	 * Getter for the {@link TestRun}'s number of {@link UnitTest}s in progress.
	 * 
	 * @return the {@link TestRun}'s number of {@link UnitTest}s in progress.
	 */
	public int getInProgress() {
		return inProgress;
	}

	/**
	 * Getter for the {@link TestRun}'s number of inconclusive
	 * {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of inconclusive {@link UnitTest}s.
	 */
	public int getInconclusive() {
		return inconclusive;
	}

	/**
	 * Getter for the {@link TestRun}'s number of not executed
	 * {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of not executed {@link UnitTest}s.
	 */
	public int getNotExecuted() {
		return notExecuted;
	}

	/**
	 * Getter for the {@link TestRun}'s number of not runnable
	 * {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of not runnable {@link UnitTest}s.
	 */
	public int getNotRunnable() {
		return notRunnable;
	}

	/**
	 * Getter for the {@link TestRun}'s number of passed {@link UnitTest}s but
	 * with aborted run.
	 * 
	 * @return the {@link TestRun}'s number of passed {@link UnitTest}s but with
	 *         aborted run.
	 */
	public int getPassedButRunAborted() {
		return passedButRunAborted;
	}

	/**
	 * Getter for the {@link TestRun}'s number of pending {@link UnitTest}s.
	 * 
	 * @return the {@link TestRun}'s number of pending {@link UnitTest}s.
	 */
	public int getPending() {
		return pending;
	}

	/**
	 * Getter for the {@link TestRun}'s number of {@link UnitTest}s with a
	 * timeout.
	 * 
	 * @return the {@link TestRun}'s number of {@link UnitTest}s with a timeout.
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * Getter for the {@link TestRun}'s number of {@link UnitTest}s with a
	 * warning.
	 * 
	 * @return the {@link TestRun}'s number of {@link UnitTest}s with a warning.
	 */
	public int getWarning() {
		return warning;
	}
}