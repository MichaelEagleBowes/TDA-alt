package de.uni_bamberg.swl.tda.logic;

/**
 * A class that makes it possible to build an {@link TestRunSetting} step by
 * step.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRunSettingBuilder {

	private String id;
	private String name;
	private String runDeploymentRoot;
	private boolean useDefaultDeploymentRoot;
	private String userDeploymentRoot;
	private String agentRuleName;

	/**
	 * Creates a new {@code TestRunSettingBuilder}.
	 * 
	 */
	public TestRunSettingBuilder() {
		super();
	}

	/**
	 * Sets the {@code TestRunSettingBuilder}'s ID.
	 * 
	 * @param id
	 *            the {@code TestRunSettingBuilder}'s ID. Mustn't be empty or
	 *            null.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the {@code TestRunSettingBuilder}'s name.
	 * 
	 * @param name
	 *            the {@code TestRunSettingBuilder}'s name. Mustn't be empty or
	 *            null.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the {@code TestRunSettingBuilder}'s run deployment root.
	 * 
	 * @param runDeploymentRoot
	 *            the {@code TestRunSettingBuilder}'s run deployment root.
	 *            Mustn't be empty or null.
	 */
	public void setRunDeploymentRoot(String runDeploymentRoot) {
		this.runDeploymentRoot = runDeploymentRoot;
	}

	/**
	 * Sets wether the {@code TestRunSettingBuilder} uses the default deployment
	 * root.
	 * 
	 * @param useDefaultDeploymentRoot
	 *            {@code true} if the {@code TestRunSetting} uses the default
	 *            deployment root, otherwise {@code false}.
	 */
	public void setUseDefaultDeploymentRoot(boolean useDefaultDeploymentRoot) {
		this.useDefaultDeploymentRoot = useDefaultDeploymentRoot;
	}

	/**
	 * Sets the {@code TestRunSettingBuilder}'s user deployment root.
	 * 
	 * @param userDeploymentRoot
	 *            the {@code TestRunSettingBuilder}'s user deployment root.
	 *            Mustn't be empty or null.
	 */
	public void setUserDeploymentRoot(String userDeploymentRoot) {
		this.userDeploymentRoot = userDeploymentRoot;
	}

	/**
	 * Sets the {@code TestRunSettingBuilder}'s agent rule name.
	 * 
	 * @param agentRuleName
	 *            the {@code TestRunSettingBuilder}'s agent rule name. Mustn't
	 *            be empty or null.
	 */
	public void setAgentRuleName(String agentRuleName) {
		this.agentRuleName = agentRuleName;
	}

	/**
	 * Creates a new {@link TestRunSetting} with the set data.
	 * 
	 * @return the new {@link TestRunSetting}.
	 * @throws TdaDataModelException
	 *             if any of the parameters was not valid.
	 */
	public TestRunSetting create() throws TdaDataModelException {
		return new TestRunSetting(id, name, runDeploymentRoot, useDefaultDeploymentRoot, userDeploymentRoot,
				agentRuleName);
	}
}
