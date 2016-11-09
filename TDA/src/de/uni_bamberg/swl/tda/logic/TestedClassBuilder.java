package de.uni_bamberg.swl.tda.logic;

import java.util.List;

/**
 * A class that makes it possible to build an {@link TestedClass} step by step.
 * 
 * @author Nicolas Gross
 *
 */

public class TestedClassBuilder {

	private String name;
	private List<UnitTest> testList;

	/**
	 * Creates a new {@code UnitTestResultBuilder}.
	 * 
	 */
	public TestedClassBuilder() {
		super();
	}

	/**
	 * Sets the {@code TestedClassBuilder}'s name.
	 * 
	 * @param name
	 *            the {@code TestedClassBuilder}'s name. Mustn't be null or
	 *            empty.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the {@code TestedClassBuilder}'s list of {@link UnitTest}s.
	 * 
	 * @param testList
	 *            the {@code TestedClassBuilder}'s list of {@link UnitTest}s.
	 *            Mustn't be null or empty.
	 */
	public void setTestList(List<UnitTest> testList) {
		this.testList = testList;
	}

	/**
	 * Creates a new {@link TestedClass} with the set data.
	 * 
	 * @return the new {@link TestedClass}.
	 * @throws TdaDataModelException
	 *             if any of the parameters was not valid.
	 */
	public TestedClass create() throws TdaDataModelException {
		return new TestedClass(name, testList);
	}
}
