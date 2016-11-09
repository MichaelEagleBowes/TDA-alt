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
	private final String storage;
	private final String adapterTypeName;
	private final String codeBase;
	private final UnitTestResult result;

	/**
	 * 
	 * @param id
	 *            the {@code UnitTest}'s ID. Mustn't be null or empty.
	 * @param name
	 *            the {@code UnitTest}'s name. Mustn't be null or empty.
	 * @param storage
	 *            the {@code UnitTest}'s storage. Mustn't be null or empty.
	 * @param adapterTypeName
	 *            the {@code UnitTest}'s adaptertype name. Mustn't be null or
	 *            empty.
	 * @param codeBase
	 *            the {@code UnitTest}'s code base. Mustn't be null or empty.
	 * @param result
	 *            the {@code UnitTest}'s result. Mustn't be null.
	 * @throws TdaDataModelException
	 *             if any of the parameters is not valid.
	 * 
	 */
	public UnitTest(String id, String name, String storage, String adapterTypeName, String codeBase,
			UnitTestResult result) throws TdaDataModelException {
		super();
		Validator.validateUnitTest(id, name, storage, adapterTypeName, codeBase, result);
		this.id = id;
		this.name = name;
		this.storage = storage;
		this.adapterTypeName = adapterTypeName;
		this.codeBase = codeBase;
		this.result = result;
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
	 * Getter for the {@code UnitTest}'s storage.
	 * 
	 * @return the {@code UnitTest}'s storage.
	 */
	public String getStorage() {
		return storage;
	}

	/**
	 * Getter for the {@code UnitTest}'s adaptertype name.
	 * 
	 * @return the {@code UnitTest}'s adaptertype name.
	 */
	public String getAdapterTypeName() {
		return adapterTypeName;
	}

	/**
	 * Getter for the {@code UnitTest}'s code base.
	 * 
	 * @return the {@code UnitTest}'s code base.
	 */
	public String getCodeBase() {
		return codeBase;
	}

	/**
	 * Getter for the {@code UnitTest}'s result.
	 * 
	 * @return the {@code UnitTest}'s result.
	 */
	public UnitTestResult getResult() {
		return result;
	}
}
