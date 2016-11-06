package de.uni_bamberg.swl.tda.logic;

/**
 * Represents an unit test.
 * 
 * @author Nicolas Gross
 *
 */

public class UnitTest {

	private final String id;
	private final String name;
	private final Outcome outcome;

	/**
	 * Creates a new executed {@code UnitTest}.
	 * 
	 * @param id
	 *            the {@code UnitTest}'s ID. Mustn't be null or empty.
	 * @param name
	 *            the {@code UnitTest}'s name. Mustn't be null or empty.
	 * @param outcome
	 *            the {@code UnitTest}'s outcome. Mustn't be null.
	 * @throws TdaDataModelException
	 *             if any of the arguments is not valid.
	 */
	public UnitTest(String id, String name, Outcome outcome) throws TdaDataModelException {
		super();
		Validator.validateUnitTest(id, name);
		this.id = id;
		this.name = name;
		this.outcome = outcome;
	}

	/**
	 * Creates a new unexecuted {@code UnitTest}. The outcome is set on
	 * {@code null}.
	 * 
	 * @param id
	 *            the {@code UnitTest}'s ID. Mustn't be null or empty.
	 * @param name
	 *            the {@code UnitTest}'s name. Mustn't be null or empty.
	 * @throws TdaDataModelException
	 *             if any of the arguments is not valid.
	 */
	public UnitTest(String id, String name) throws TdaDataModelException {
		super();
		Validator.validateUnitTest(id, name);
		this.id = id;
		this.name = name;
		this.outcome = null;
	}

	/**
	 * Getter for the {@code UnitTest}'s ID.
	 * 
	 * @return the {@code UnitTest}'s ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter for the {@code UnitTest}'s name.
	 * 
	 * @return the {@code UnitTest}'s name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the {@code UnitTest}'s {@link Outcome}.
	 * 
	 * @return the {@code UnitTest}'s {@link Outcome}.
	 */
	public Outcome getOutcome() {
		return outcome;
	}
}
