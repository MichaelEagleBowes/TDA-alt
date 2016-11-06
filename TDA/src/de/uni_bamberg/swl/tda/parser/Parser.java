package de.uni_bamberg.swl.tda.parser;

import de.uni_bamberg.swl.tda.logic.TestRun;

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
