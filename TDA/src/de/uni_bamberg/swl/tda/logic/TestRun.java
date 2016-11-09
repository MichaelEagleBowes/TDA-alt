package de.uni_bamberg.swl.tda.logic;

import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Represents a test run.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRun {

	private final String xmlns;
	private final String id;
	private final String name;
	private final String runUser;
	private final ZonedDateTime creationDate;
	private final ZonedDateTime finishDate;
	private final ZonedDateTime queuingDate;
	private final ZonedDateTime startDate;
	private final List<TestedClass> classList;
	private final TestRunSetting setting;
	private final TestRunResult result;

	/**
	 * Creates a new {@code TestRun}.
	 * 
	 * @param xmlns
	 *            the {@code TestRun}'s namespace. Mustn't be null or empty.
	 * @param id
	 *            the {@code TestRun}'s ID. Mustn't be null or empty.
	 * @param name
	 *            the {@code TestRun}'s name. Mustn't be null or empty.
	 * @param runUser
	 *            the {@code TestRun}'s run user. Mustn't be null or empty.
	 * @param creationDate
	 *            the {@code TestRun}'s creation date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 * @param finishDate
	 *            the {@code TestRun}'s finish date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 * @param queuingDate
	 *            the {@code TestRun}'s queuing date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 * @param startDate
	 *            the {@code TestRun}'s start date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 * @param classList
	 *            the {@code TestRun}'s list of tested classes. Mustn't be null
	 *            or empty.
	 * @param setting
	 *            the {@code TestRun}'s setting. Mustn't be null.
	 * @param result
	 *            the {@code TestRun}'s result. Mustn't be null.
	 * @throws TdaDataModelException
	 *             if any of the pararmeters is not valid.
	 */
	public TestRun(String xmlns, String id, String name, String runUser, String creationDate, String finishDate,
			String queuingDate, String startDate, List<TestedClass> classList, TestRunSetting setting,
			TestRunResult result) throws TdaDataModelException {
		super();
		Validator.validateTestRun(xmlns, id, name, runUser, creationDate, finishDate, queuingDate, startDate, classList,
				setting, result);
		this.xmlns = xmlns;
		this.id = id;
		this.name = name;
		this.runUser = runUser;
		try {
			this.creationDate = ZonedDateTime.parse(creationDate);
			this.finishDate = ZonedDateTime.parse(finishDate);
			this.queuingDate = ZonedDateTime.parse(queuingDate);
			this.startDate = ZonedDateTime.parse(startDate);
		} catch (DateTimeException e) {
			throw new TdaDataModelException(
					"A problem occurred while parsing a date. Please check the format of the dates.", e);
		}
		this.classList = classList;
		this.setting = setting;
		this.result = result;
	}

	/**
	 * Getter for the {@code TestRun}'s ID.
	 * 
	 * @return the {@code TestRun}'s ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter for the {@code TestRun}'s creation date.
	 * 
	 * @return the {@code TestRun}'s creation date.
	 */
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * Getter for the list of the {@code TestRun}'s {@link TestedClass}'.
	 * 
	 * @return the list of the {@code TestRun}'s {@link TestedClass}'.
	 */
	public List<TestedClass> getCLassList() {
		return classList;
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
		for (TestedClass testedClass : classList) {
			if (testedClass.getName().equals(name)) {
				return testedClass;
			}
		}
		throw new TdaDataModelException("Class " + name + " not found.");
	}

	/**
	 * Getter for the {@code TestRun}'s result.
	 * 
	 * @return the {@code TestRun}'s result.
	 */
	public TestRunResult getResult() {
		return result;
	}

	/**
	 * Getter for the {@code TestRun}'s xmlns.
	 * 
	 * @return the {@code TestRun}'s xmlns.
	 */
	public String getXmlns() {
		return xmlns;
	}

	/**
	 * Getter for the {@code TestRun}'s name.
	 * 
	 * @return the {@code TestRun}'s name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the {@code TestRun}'s run user.
	 * 
	 * @return the {@code TestRun}'s run user.
	 */
	public String getRunUser() {
		return runUser;
	}

	/**
	 * Getter for the {@code TestRun}'s finish date.
	 * 
	 * @return the {@code TestRun}'s finish date.
	 */
	public ZonedDateTime getFinishDate() {
		return finishDate;
	}

	/**
	 * Getter for the {@code TestRun}'s queuing date.
	 * 
	 * @return the {@code TestRun}'s queuing date.
	 */
	public ZonedDateTime getQueuingDate() {
		return queuingDate;
	}

	/**
	 * Getter for the {@code TestRun}'s start date.
	 * 
	 * @return the {@code TestRun}'s start date.
	 */
	public ZonedDateTime getStartDate() {
		return startDate;
	}

	/**
	 * Getter for the {@code TestRun}'s setting.
	 * 
	 * @return the {@code TestRun}'s setting.
	 */
	public TestRunSetting getSetting() {
		return setting;
	}
}
