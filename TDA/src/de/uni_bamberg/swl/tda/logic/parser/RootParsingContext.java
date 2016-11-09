package de.uni_bamberg.swl.tda.logic.parser;

import de.uni_bamberg.swl.tda.logic.TestRun;

import javax.xml.stream.events.StartElement;

/**
 * Handles the parsing of the root element {@code <TestRun>} and its contained simple elements.
 *
 * @author Florian Beetz
 */
class RootParsingContext extends ParsingContextBase {

    // private final TestRunBuilder builder = new TestRunBuilder();

    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        // TODO: implement me based on the Builders that will be provided by Nicolas Gross
        return super.handleStartElement(startElement);
    }

    @Override
    public TestRun getResult() throws IllegalStateException {
        // return builder.build();
        throw new UnsupportedOperationException();
    }
}
