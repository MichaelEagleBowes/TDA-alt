package de.uni_bamberg.swl.tda.logic;

/**
 * Represents the setting for a {@link TestRun}.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRunSetting {

	private final String id;
	private final String name;
	private final String runDeploymentRoot;
	private final boolean useDefaultDeploymentRoot;
	private final String userDeploymentRoot;
	private final String agentRuleName;

	/**
	 * Creates a new setting.
	 * 
	 * @param id
	 *            the {@code TestRunSetting}'s ID. Mustn't be empty or null.
	 * @param name
	 *            the {@code TestRunSetting}'s name. Mustn't be empty or null.
	 * @param runDeploymentRoot
	 *            the {@code TestRunSetting}'s run deployment root. Mustn't be
	 *            empty or null.
	 * @param useDefaultDeploymentRoot
	 *            wether the {@code TestRunSetting} uses the default deployment
	 *            root.
	 * @param userDeploymentRoot
	 *            the {@code TestRunSetting}'s user deployment root. Mustn't be
	 *            empty or null.
	 * @param agentRuleName
	 *            the {@code TestRunSetting}'s agent rule name. Mustn't be empty
	 *            or null.
	 * @throws TdaDataModelException
	 *             if any of the parameters is not valid.
	 */
	public TestRunSetting(String id, String name, String runDeploymentRoot, boolean useDefaultDeploymentRoot,
			String userDeploymentRoot, String agentRuleName) throws TdaDataModelException {
		super();
		Validator.validateTestRunSetting(id, name, runDeploymentRoot, useDefaultDeploymentRoot, userDeploymentRoot,
				agentRuleName);
		this.id = id;
		this.name = name;
		this.runDeploymentRoot = runDeploymentRoot;
		this.useDefaultDeploymentRoot = useDefaultDeploymentRoot;
		this.userDeploymentRoot = userDeploymentRoot;
		this.agentRuleName = agentRuleName;
	}

	/**
	 * Getter for the {@code TestRunSetting}'s ID.
	 * 
	 * @return the {@code TestRunSetting}'s ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter for the {@code TestRunSetting}'s name.
	 * 
	 * @return the {@code TestRunSetting}'s name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the {@code TestRunSetting}'s run deployment root.
	 * 
	 * @return the {@code TestRunSetting}'s run deployment root.
	 */
	public String getRunDeploymentRoot() {
		return runDeploymentRoot;
	}

	/**
	 * Getter for the boolean wether the {@code TestRunSetting} uses the default
	 * deployment root.
	 * 
	 * @return {@code true} if the {@code TestRunSetting} uses the default
	 *         deployment root.
	 */
	public boolean isUseDefaultDeploymentRoot() {
		return useDefaultDeploymentRoot;
	}

	/**
	 * Getter for the {@code TestRunSetting}'s user deployment root.
	 * 
	 * @return the {@code TestRunSetting}'s user deployment root.
	 */
	public String getUserDeploymentRoot() {
		return userDeploymentRoot;
	}

	/**
	 * Getter for the {@code TestRunSetting}'s agent rule name.
	 * 
	 * @return the {@code TestRunSetting}'s agent rule name.
	 */
	public String getAgentRuleName() {
		return agentRuleName;
	}
}
