package de.uni_bamberg.swl.tda.logic.parser;

import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;

/**
 * Parses the {@code <TestEntries>} element in the XML.
 * 
 * @author Michael Bowes
 */
public class TestEntriesContext extends ParsingContextBase {

	private final ParsingContext parent;

    public TestEntriesContext(ParsingContext parent) {
        this.parent = parent;
    }
	
	/**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        return super.handleStartElement(startElement); // TestEntries are not parsed
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleEndElement(EndElement endElement) throws ParserException {
        if (XMLName.Element.TEST_ENTRIES.equals(endElement.getName().getLocalPart())) {
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
                        XMLName.Element.TEST_ENTRIES)
        );
    }
}
