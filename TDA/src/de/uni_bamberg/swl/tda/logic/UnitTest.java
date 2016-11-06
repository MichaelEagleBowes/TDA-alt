package de.uni_bamberg.swl.tda.logic;

/**
 * Represents an unit test.
 * 
 * @author Nicolas Gross
 *
 */

public class UnitTest {

	private final String ID;
	private final String NAME;
	private final Outcome OUTCOME;

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
		this.ID = id;
		this.NAME = name;
		this.OUTCOME = outcome;
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
		this.ID = id;
		this.NAME = name;
		this.OUTCOME = null;
	}

	/**
	 * Getter for the {@code UnitTest}'s ID.
	 * 
	 * @return the {@code UnitTest}'s ID.
	 */
	public String getId() {
		return ID;
	}

	/**
	 * Getter for the {@code UnitTest}'s name.
	 * 
	 * @return the {@code UnitTest}'s name.
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * Getter for the {@code UnitTest}'s {@link Outcome}.
	 * 
	 * @return the {@code UnitTest}'s {@link Outcome}.
	 */
	public Outcome getOutcome() {
		return OUTCOME;
	}
}
