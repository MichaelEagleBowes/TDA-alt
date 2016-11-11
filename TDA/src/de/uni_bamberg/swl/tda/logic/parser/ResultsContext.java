package de.uni_bamberg.swl.tda.logic.parser;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;
import de.uni_bamberg.swl.tda.logic.UnitTestBuilder;
import de.uni_bamberg.swl.tda.logic.UnitTestResultBuilder;
import de.uni_bamberg.swl.tda.logic.Outcome;

/**
 * Parses the {@code <Results>} element in the XML.
 * 
 * @author Michael Bowes
 */
public class ResultsContext extends ParsingContextBase {

	private final ParsingContext parent;
	private final UnitTestBuilder resultBuilder;
	
	private final UnitTestResultBuilder builder = new UnitTestResultBuilder();

    public ResultsContext(ParsingContext parent, UnitTestBuilder builder) {
    	this.parent = parent;
    	this.resultBuilder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        // <ResultSummary>
        if (XMLName.Element.UNIT_TEST_RESULT.equals(startElement.getName().getLocalPart())) {
        	String Stringoutcome = getAttributeOrThrow(startElement, XMLName.Attribute.OUTCOME);
        	Outcome outcome = Outcome.valueOf(Stringoutcome);
            builder.setOutcome(outcome);
        	
        	builder.setComputerName(getAttributeOrThrow(startElement, XMLName.Attribute.COMPUTER_NAME));
        	builder.setDataRowInfo(getAttributeOrThrow(startElement, XMLName.Attribute.DATA_ROW_INFO));
        	builder.setDuration(getAttributeOrThrow(startElement, XMLName.Attribute.DURATION));
        	builder.setEndTime(getAttributeOrThrow(startElement, XMLName.Attribute.END_TIME));
        	builder.setExecutionId(getAttributeOrThrow(startElement, XMLName.Attribute.EXECUTION_ID));
        	builder.setOutcome(outcome);
        	builder.setRelativeResultsDirectory(getAttributeOrThrow(startElement, XMLName.Attribute.RELATIVE_RESULTS_DIRECTORY));
        	builder.setStartTime(getAttributeOrThrow(startElement, XMLName.Attribute.START_TIME));
        	builder.setTestListId(getAttributeOrThrow(startElement, XMLName.Attribute.TEST_LIST_ID));
        	builder.setTestType(getAttributeOrThrow(startElement, XMLName.Attribute.TEST_TYPE));
        }

        return this;
}
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleCharacters(Characters characters) throws ParserException{
    	
        // <Message> or <StdOut> within Output
    	builder.setStdOut(characters.getData());
    	
    	return this;
}
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleEndElement(EndElement endElement) throws ParserException {
        if (XMLName.Element.RESULTS.equals(endElement.getName().getLocalPart())) {
            // build the results
            try {
                resultBuilder.setResult(builder.create());
            } catch (TdaDataModelException e) {
                throw new ParserException(
                        String.format("Failed to parse '%s' element. " +
                                "The structure was valid, but the contents could not be validated.",
                                XMLName.Element.RESULT_SUMMARY),
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
                        XMLName.Element.RESULTS)
        );
}
}
