package de.uni_bamberg.swl.tda.logic;

import java.util.List;

/**
 * A class that makes it possible to build an {@link TestRun} step by step.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRunBuilder {

	private String xmlns;
	private String id;
	private String name;
	private String runUser;
	private String creationDate;
	private String finishDate;
	private String queuingDate;
	private String startDate;
	private List<TestedClass> classList;
	private TestRunSetting setting;
	private TestRunResult result;

	/**
	 * Creates a new {@code TestRunBuilder}.
	 * 
	 */
	public TestRunBuilder() {
		super();
	}

	/**
	 * Sets the {@code TestRunBuilder}'s namespace.
	 * 
	 * @param xmlns
	 *            the {@code TestRunBuilder}'s namespace. Mustn't be null or
	 *            empty.
	 */
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s ID.
	 * 
	 * @param id
	 *            the {@code TestRunBuilder}'s ID. Mustn't be null or empty.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s name.
	 * 
	 * @param name
	 *            the {@code TestRunBuilder}'s name. Mustn't be null or empty.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s run user.
	 * 
	 * @param runUser
	 *            the {@code TestRunBuilder}'s run user. Mustn't be null or
	 *            empty.
	 */
	public void setRunUser(String runUser) {
		this.runUser = runUser;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s creation date.
	 * 
	 * @param creationDate
	 *            the {@code TestRunBuilder}'s creation date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s finish date.
	 * 
	 * @param finishDate
	 *            the {@code TestRunBuilder}'s finish date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s queuing date.
	 * 
	 * @param queuingDate
	 *            the {@code TestRunBuilder}'s queuing date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 */
	public void setQueuingDate(String queuingDate) {
		this.queuingDate = queuingDate;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s start date.
	 * 
	 * @param startDate
	 *            the {@code TestRunBuilder}'s start date in the form
	 *            "2016-09-21T13:37:43.7071946+02:00".
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s list of tested classes.
	 * 
	 * @param classList
	 *            the {@code TestRunBuilder}'s list of tested classes. Mustn't
	 *            be null or empty.
	 */
	public void setClassList(List<TestedClass> classList) {
		this.classList = classList;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s setting.
	 * 
	 * @param setting
	 *            the {@code TestRunBuilder}'s setting. Mustn't be null.
	 */
	public void setSetting(TestRunSetting setting) {
		this.setting = setting;
	}

	/**
	 * Sets the {@code TestRunBuilder}'s result.
	 * 
	 * @param result
	 *            the {@code TestRunBuilder}'s result. Mustn't be null.
	 */
	public void setResult(TestRunResult result) {
		this.result = result;
	}

	/**
	 * Creates a new {@link TestRun} with the set data.
	 * 
	 * @return the new {@link TestRun}.
	 * @throws TdaDataModelException
	 *             if any of the parameters was not valid.
	 */
	public TestRun create() throws TdaDataModelException {
		return new TestRun(xmlns, id, name, runUser, creationDate, finishDate, queuingDate, startDate, classList,
				setting, result);
	}
}
