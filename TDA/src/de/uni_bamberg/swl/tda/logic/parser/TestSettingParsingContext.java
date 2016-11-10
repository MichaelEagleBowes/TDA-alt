package de.uni_bamberg.swl.tda.logic.parser;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;
import de.uni_bamberg.swl.tda.logic.TestRunBuilder;
import de.uni_bamberg.swl.tda.logic.TestRunSettingBuilder;

import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

/**
 * Parses the {@code <TestSettings>} element in the XML.
 *
 * @author Florian Beetz
 */
class TestSettingParsingContext extends ParsingContextBase {

    private final ParsingContext parent;
    private final TestRunBuilder rootBuilder;

    private final TestRunSettingBuilder builder = new TestRunSettingBuilder();

    public TestSettingParsingContext(ParsingContext parent, TestRunBuilder builder) {
        this.parent = parent;
        this.rootBuilder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        // <TestSettings>
        if (XMLName.Element.TEST_SETTINGS.equals(startElement.getName().getLocalPart())) {
            builder.setId(getAttributeOrThrow(startElement, XMLName.Attribute.ID));
            builder.setName(getAttributeOrThrow(startElement, XMLName.Attribute.NAME));
        }

        // <Deployment>
        if (XMLName.Element.DEPLOYMENT.equals(startElement.getName().getLocalPart())) {
            builder.setRunDeploymentRoot(getAttributeOrThrow(startElement, XMLName.Attribute.RUN_DEPLOYMENT_ROOT));
            String useDeploymentRoot = getAttributeOrThrow(startElement, XMLName.Attribute.USER_DEPLOYMENT_ROOT);
            builder.setUseDefaultDeploymentRoot(Boolean.parseBoolean(useDeploymentRoot));
            builder.setUserDeploymentRoot(getAttributeOrThrow(startElement, XMLName.Attribute.USER_DEPLOYMENT_ROOT));
        }

        // <AgentRule>
        if (XMLName.Element.AGENT_RULE.equals(startElement.getName().getLocalPart())) {
            builder.setAgentRuleName(getAttributeOrThrow(startElement, XMLName.Attribute.NAME));
        }

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleEndElement(EndElement endElement) throws ParserException {
        if (XMLName.Element.TEST_SETTINGS.equals(endElement.getName().getLocalPart())) {
            // build the settings
            try {
                rootBuilder.setSetting(builder.create());
            } catch (TdaDataModelException e) {
                throw new ParserException(
                        String.format("Failed to parse '%s' element. " +
                                "The structure was valid, but the contents could not be validated.",
                                XMLName.Element.TEST_SETTINGS),
                        e
                );
            }

            // switch back to parent context
            return parent;
        }

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestRun getResult() throws IllegalStateException, TdaDataModelException {
        throw new IllegalStateException(
                String.format("The result of the parsing operation could not be determined. " +
                        "The currently parsed element is '%s'.",
                        XMLName.Element.TEST_SETTINGS)
        );
    }
}
