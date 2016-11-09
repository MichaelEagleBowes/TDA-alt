package de.uni_bamberg.swl.tda.logic;

/**
 * A class that makes it possible to build an {@link UnitTest} step by step.
 * 
 * @author Nicolas Gross
 *
 */

public class UnitTestBuilder {

	private String id;
	private String name;
	private String storage;
	private String adapterTypeName;
	private String codeBase;
	private UnitTestResult result;

	/**
	 * Creates a new {@code UnitTestBuilder}.
	 * 
	 */
	public UnitTestBuilder() {
		super();
	}

	/**
	 * Sets the {@code UnitTestBuilder}'s ID.
	 * 
	 * @param id
	 *            the {@code UnitTestBuilder}'s ID. Mustn't be null or empty.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the {@code UnitTestBuilder}'s name.
	 * 
	 * @param name
	 *            the {@code UnitTestBuilder}'s name. Mustn't be null or empty.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the {@code UnitTestBuilder}'s storage.
	 * 
	 * @param storage
	 *            the {@code UnitTestBuilder}'s storage. Mustn't be null or
	 *            empty.
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}

	/**
	 * Sets the {@code UnitTestBuilder}'s adaptertype name.
	 * 
	 * @param adapterTypeName
	 *            the {@code UnitTestBuilder}'s adaptertype name. Mustn't be
	 *            null or empty.
	 */
	public void setAdapterTypeName(String adapterTypeName) {
		this.adapterTypeName = adapterTypeName;
	}

	/**
	 * Sets the {@code UnitTestBuilder}'s code base.
	 * 
	 * @param codeBase
	 *            the {@code UnitTestBuilder}'s code base. Mustn't be null or
	 *            empty.
	 */
	public void setCodeBase(String codeBase) {
		this.codeBase = codeBase;
	}

	/**
	 * Sets the {@code UnitTestBuilder}'s result.
	 * 
	 * @param result
	 *            the {@code UnitTestBuilder}'s result. Mustn't be null.
	 */
	public void setResult(UnitTestResult result) {
		this.result = result;
	}

	/**
	 * Creates a new {@link UnitTest} with the set data.
	 * 
	 * @return the new {@link UnitTest}.
	 * @throws TdaDataModelException
	 *             if any of the arguments was not valid.
	 */
	public UnitTest create() throws TdaDataModelException {
		return new UnitTest(id, name, storage, adapterTypeName, codeBase, result);
	}
}
