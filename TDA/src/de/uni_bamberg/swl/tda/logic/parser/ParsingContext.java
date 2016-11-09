package de.uni_bamberg.swl.tda.logic.parser;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;

import javax.xml.stream.events.XMLEvent;

/**
 * Handles a sequence of {@link XMLEvent}s.
 *
 * {@link ParsingContext}s may decide weather it is appropriate to switch to another context.
 *
 * @author Florian Beetz
 */
interface ParsingContext {

    /**
     * Handles one {@link XMLEvent}.
     *
     * The parser is instructed to pass all further {@link XMLEvent}s to the returned
     * {@link ParsingContext}. To signal no context switch shall happen {@code this} can be
     * returned.
     *
     * Implementors may <em>not</em> return {@code null}.
     *
     * @param event the event to handle.
     * @return the {@link ParsingContext} to switch to.
     * @throws ParserException signals an error while parsing.
     */
    ParsingContext handleEvent(XMLEvent event) throws ParserException;

    /**
     * Returns the current result of the parser.
     *
     * Implementors should not return {@code null} but rather throw an
     * {@link IllegalStateException}.
     *
     * @return the parsed {@link TestRun}
     * @throws IllegalStateException Signals that the parser is currently not in a state to return
     *                               any useful result.
     * @throws TdaDataModelException Signals that the parser was able to parse the XML but the
     *                               contained data is invalid.
     */
    TestRun getResult() throws IllegalStateException, TdaDataModelException;
}
