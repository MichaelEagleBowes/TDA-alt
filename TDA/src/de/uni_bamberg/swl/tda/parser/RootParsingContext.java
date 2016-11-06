package de.uni_bamberg.swl.tda.parser;

import de.uni_bamberg.swl.tda.logic.Outcome;
import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;
import de.uni_bamberg.swl.tda.logic.TestedClass;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.StartElement;

/**
 * Handles the parsing of the root element {@code <TestRun>} and its contained simple elements.
 *
 * @author Florian Beetz
 */
class RootParsingContext extends ParsingContextBase {

    private String id;
    private String creationDate;
    private Outcome outcome;
    private List<TestedClass> testedClasses = new ArrayList<>();
    private int totalTests;
    private int executedTests;
    private int passedTests;
    private int failedTests;

    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        // TODO: implement me
        return super.handleStartElement(startElement);
    }

    @Override
    public TestRun getResult() throws IllegalStateException {
        try {
            return new TestRun(id, creationDate, outcome, testedClasses, totalTests, executedTests,
                    passedTests, failedTests);
        } catch (TdaDataModelException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
