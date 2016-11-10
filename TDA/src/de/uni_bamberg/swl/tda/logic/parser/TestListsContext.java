package de.uni_bamberg.swl.tda.logic.parser;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;
import de.uni_bamberg.swl.tda.logic.TestRunBuilder;

import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

/**
 * Parses the {@code <TestLists>} element in the XML.
 *
 * Currently has no effect.
 *
 * @author Florian Beetz
 */
class TestListsContext extends ParsingContextBase {

    private final ParsingContext parent;

    public TestListsContext(ParsingContext parent) {
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        return super.handleStartElement(startElement); // TestLists are not parsed
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleEndElement(EndElement endElement) throws ParserException {
        if (XMLName.Element.TEST_LISTS.equals(endElement.getName().getLocalPart())) {
            return parent; // switch back to parent context
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
                        XMLName.Element.TEST_LISTS)
        );
    }
}
