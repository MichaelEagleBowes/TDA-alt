package de.uni_bamberg.swl.tda.logic.parser;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;
import de.uni_bamberg.swl.tda.logic.TestRunBuilder;

import javax.xml.stream.events.StartElement;

/**
 * Handles the parsing of the root element {@code <TestRun>} and its contained simple elements.
 *
 * @author Florian Beetz
 */
class RootParsingContext extends ParsingContextBase {

    private final TestRunBuilder builder = new TestRunBuilder();

    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {

        // <TestRun>
        if (XMLName.Element.TEST_RUN.equals(startElement.getName().getLocalPart())) {
            builder.setXmlns(getAttributeOrThrow(startElement, XMLName.Attribute.XMLNS));
            builder.setId(getAttributeOrThrow(startElement, XMLName.Attribute.ID));
            builder.setName(getAttributeOrThrow(startElement, XMLName.Attribute.NAME));
            builder.setRunUser(getAttributeOrThrow(startElement, XMLName.Attribute.RUN_USER));
            return this;
        }

        // <TestSettings>
        if (XMLName.Element.TEST_SETTINGS.equals(startElement.getName().getLocalPart())) {
            TestSettingParsingContext context = new TestSettingParsingContext(this, builder);
            context.handleStartElement(startElement);
            return context;
        }

        // <Times>
        if (XMLName.Element.TIMES.equals(startElement.getName().getLocalPart())) {
            builder.setCreationDate(getAttributeOrThrow(startElement, XMLName.Attribute.CREATION));
            builder.setFinishDate(getAttributeOrThrow(startElement, XMLName.Attribute.FINISH));
            builder.setQueuingDate(getAttributeOrThrow(startElement, XMLName.Attribute.QUEUEING));
            builder.setStartDate(getAttributeOrThrow(startElement, XMLName.Attribute.START));
            return this;
        }

        // <ResultSummary>
        if (XMLName.Element.RESULT_SUMMARY.equals(startElement.getName().getLocalPart())) {
            ResultSummaryContext context = new ResultSummaryContext(this, builder);
            context.handleStartElement(startElement);
            return context;
        }

        // <TestDefinitions>
        if (XMLName.Element.TEST_DEFINITIONS.equals(startElement.getName().getLocalPart())) {
            TestDefinitionsContext context = new TestDefinitionsContext(this, builder);
            context.handleStartElement(startElement);
            return context;
        }

        // <TestLists>
        if (XMLName.Element.TEST_LISTS.equals(startElement.getName().getLocalPart())) {
            TestListsContext context = new TestListsContext(this);
            context.handleStartElement(startElement);
            return context;
        }

        // <TestEntries>
        if (XMLName.Element.TEST_ENTRIES.equals(startElement.getName().getLocalPart())) {
            TestEntriesContext context = new TestEntriesContext(this, builder);
            context.handleStartElement(startElement);
            return context;
        }

        // <Results>
        if (XMLName.Element.RESULTS.equals(startElement.getName().getLocalPart())) {
            ResultsContext context = new ResultsContext(this, builder);
            context.handleStartElement(startElement);
            return context;
        }

        // unknown element
        throw new ParserException(String.format("Encountered an unknown element '%s' in XML.",
                startElement.getName().getLocalPart()));
    }

    @Override
    public TestRun getResult() throws IllegalStateException, TdaDataModelException {
        return builder.create();
    }
}
