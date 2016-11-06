package de.uni_bamberg.swl.tda.parser;

import de.uni_bamberg.swl.tda.logic.TestRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

/**
 * Provides parsing functionality to the application.
 *
 * @author Florian Beetz
 */
public class Parser {

    private static final XMLInputFactory FACTORY = XMLInputFactory.newFactory();

    /**
     * Parses XML from a {@link File} to a {@link TestRun}.
     *
     * @param file the file to parse.
     * @return the parsed {@link TestRun}.
     * @throws FileNotFoundException Signals that the given file could not be found.
     * @throws ParserException Signals that an error occurred while parsing.
     * @see #parse(InputStream)
     */
    public static TestRun parse(File file) throws FileNotFoundException, ParserException {
        return parse(new FileInputStream(file));
    }

    /**
     * Parses XML form an {@link InputStream} to a {@link TestRun}.
     *
     * @param stream the input stream.
     * @return the parsed {@link TestRun}.
     * @throws ParserException Signals that an error occurred while parsing.
     */
    public static TestRun parse(InputStream stream) throws ParserException {
        try {
            XMLEventReader reader = FACTORY.createXMLEventReader(stream);

            ParsingContext context = new RootParsingContext();

            while (reader.hasNext()) {
                context = context.handleEvent(reader.nextEvent());
            }

            return context.getResult();
        } catch (XMLStreamException e) {
            throw new ParserException("Failed to read XML.", e);
        }
    }

}
