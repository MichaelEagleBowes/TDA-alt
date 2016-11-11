package de.uni_bamberg.swl.tda.logic.parser;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;
import de.uni_bamberg.swl.tda.logic.TestRunBuilder;
import de.uni_bamberg.swl.tda.logic.TestRunResultBuilder;
import de.uni_bamberg.swl.tda.logic.Outcome;

import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;

/**
 * Parses the {@code <ResultSummary>} element in the XML.
 * 
 * @author Michael Bowes
 */
public class ResultSummaryContext extends ParsingContextBase {

	private final ParsingContext parent;
	private final TestRunBuilder rootBuilder;
	
	private final TestRunResultBuilder builder = new TestRunResultBuilder();

    public ResultSummaryContext(ParsingContext parent, TestRunBuilder builder) {
    	this.parent = parent;
    	this.rootBuilder = builder;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        // <ResultSummary>
        if (XMLName.Element.RESULT_SUMMARY.equals(startElement.getName().getLocalPart())) {
        	String Stringoutcome = getAttributeOrThrow(startElement, XMLName.Attribute.OUTCOME);
        	Outcome outcome = Outcome.valueOf(Stringoutcome);
            builder.setOutcome(outcome);
        }

        // <Counters>
        if (XMLName.Element.COUNTERS.equals(startElement.getName().getLocalPart())) {
        	builder.setAborted(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.ABORTED)));
        	builder.setCompleted(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.COMPLETED)));
        	builder.setDisconnected(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.DISCONNECTED)));
        	builder.setError(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.ERROR)));
        	builder.setExecuted(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.EXECUTED)));
        	builder.setFailed(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.FAILED)));
        	builder.setInProgress(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.IN_PROGRESS)));
        	builder.setInconclusive(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.INCONCLUSIVE)));
        	builder.setNotExecuted(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.NOT_EXECUTED)));
        	builder.setNotRunnable(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.NOT_RUNNABLE)));
        	builder.setPassed(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.PASSED)));
        	builder.setPassedButRunAborted(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.PASSED_BUT_RUN_ABORTED)));
        	builder.setPending(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.PENDING)));
        	builder.setTimeout(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.TIMEOUT)));
        	builder.setTotal(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.TOTAL)));
        	builder.setWarning(Integer.parseInt(getAttributeOrThrow(startElement, XMLName.Attribute.WARNING)));
        }

        return this;
}
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleCharacters(Characters characters) throws ParserException{
    	
        // <Std_Out> within Output
    	builder.setStdOut(characters.getData());
    	
    	return this;
}
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleEndElement(EndElement endElement) throws ParserException {
        if (XMLName.Element.RESULT_SUMMARY.equals(endElement.getName().getLocalPart())) {
            // build summary of the results
            try {
                rootBuilder.setResult(builder.create());
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
                        XMLName.Element.TEST_SETTINGS)
        );
}
}

