package de.uni_bamberg.swl.tda.logic;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * Represents a test run.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRun {

	private final String ID;
	private final LocalDateTime CREATION_DATE;
	private final Outcome OUTCOME;
	private final List<TestedClass> CLASS_LIST;
	private final TestOutcomeCounter COUNTER;

	/**
	 * Creates a new {@code TestRun}.
	 * 
	 * @param id
	 *            the {@code TestRun}'s ID. Mustn't be null or empty.
	 * @param creationDate
	 *            the {@code TestRun}'s creation date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 * @param outcome
	 *            the {@code TestRun}'s outcome. Mustn't be null.
	 * @param classList
	 *            the {@code TestRun}'s list of tested classes. Mustn't be null
	 *            or empty.
	 * @param totalTests
	 *            the {@code TestRun}'s number of total tests. Mustn't be below
	 *            one.
	 * @param executedTests
	 *            the {@code TestRun}'s number of executed tests. Mustn't be
	 *            below zero.
	 * @param passedTests
	 *            the {@code TestRun}'s number of passed tests. Mustn't be below
	 *            zero.
	 * @param failedTests
	 *            the {@code TestRun}'s number of failed tests. Mustn't be below
	 *            zero.
	 * @throws TdaDataModelException
	 *             if any of the arguments is not valid.
	 */
	public TestRun(String id, String creationDate, Outcome outcome, List<TestedClass> classList, int totalTests,
			int executedTests, int passedTests, int failedTests) throws TdaDataModelException {
		super();
		Validator.validateTestRun(id, creationDate, outcome, classList);
		ID = id;
		CREATION_DATE = stringToDate(creationDate);
		OUTCOME = outcome;
		CLASS_LIST = classList;
		COUNTER = new TestOutcomeCounter(totalTests, executedTests, passedTests, failedTests);
	}

	/**
	 * Parses a {@link String} in form of "2016-09-21T13:37:43.7071946+02:00" to
	 * a {@link Date}.
	 * 
	 * @param dateAsString
	 *            the date as {@link String}.
	 * @return the date as {@link LocalDateTime}.
	 * @throws TdaDataModelException
	 *             if a problem occurs while parsing the date.
	 */
	private LocalDateTime stringToDate(String dateAsString) throws TdaDataModelException {
		try {
			Instant instant = Instant.parse(dateAsString.substring(0, dateAsString.length() - 6) + "Z");
			LocalDateTime date = LocalDateTime.ofInstant(instant,
					ZoneOffset.of((dateAsString.substring(dateAsString.length() - 6, dateAsString.length()))));
			return date;
		} catch (DateTimeException e) {
			throw new TdaDataModelException(
					"A problem occurred while parsing the date. Please check the format of the string.", e);
		}
	}

	/**
	 * Getter for the {@code TestRun}'s ID.
	 * 
	 * @return the {@code TestRun}'s ID.
	 */
	public String getId() {
		return ID;
	}

	/**
	 * Getter for the {@code TestRun}'s creation date.
	 * 
	 * @return the {@code TestRun}'s creation date.
	 */
	public LocalDateTime getCreationDate() {
		return CREATION_DATE;
	}

	/**
	 * Getter for the {@code TestRun}'s overall outcome.
	 * 
	 * @return {@code true} if no {@link UnitTest} failed, otherwise
	 *         {@code false}.
	 */
	public Outcome getOutcome() {
		return OUTCOME;
	}

	/**
	 * Getter for the list of the {@code TestRun}'s {@link TestedClass}'.
	 * 
	 * @return the list of the {@code TestRun}'s {@link TestedClass}'.
	 */
	public List<TestedClass> getCLassList() {
		return CLASS_LIST;
	}

	/**
	 * Getter for a specific class of the TestRun.
	 * 
	 * @param name
	 *            the name of the class.
	 * @return the class with the respective name, if the class wasn't found,
	 *         {@code null} will be returned.
	 * @throws TdaDataModelException
	 *             if the class is not found.
	 */
	public TestedClass getTestedClass(String name) throws TdaDataModelException {
		for (TestedClass testedClass : CLASS_LIST) {
			if (testedClass.getName().equals(name)) {
				return testedClass;
			}
		}
		throw new TdaDataModelException("Class " + name + " not found.");
	}

	/**
	 * Getter for the {@code TestRun}'s counter, which counts the quantity of
	 * the different {@link Outcome}s of all {@link UnitTest}s.
	 * 
	 * @return the {@code TestRun}'s counter.
	 */
	public TestOutcomeCounter getCounter() {
		return COUNTER;
	}
}
