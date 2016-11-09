package de.uni_bamberg.swl.tda.logic.parser;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * Handles a sequence of {@link XMLEvent}s.
 *
 * The {@link XMLEvent}s are split up by their type and passed on to appropriate handlers.
 *
 * Implementors may not need to not override all handlers. In that case a default handler that does
 * nothing is implemented.
 *
 * @author Florian Beetz
 */
abstract class ParsingContextBase extends XMLUtilities implements ParsingContext {

    /**
     * {@inheritDoc}
     */
    @Override
    public ParsingContext handleEvent(XMLEvent event) throws ParserException {
        switch (event.getEventType()) {
            case XMLEvent.START_ELEMENT:
                return handleStartElement(event.asStartElement());
            case XMLEvent.CHARACTERS:
                return handleCharacters(event.asCharacters());
            case XMLEvent.END_ELEMENT:
                return handleEndElement(event.asEndElement());
            default:
                return handleUnknownElement(event);
        }
    }

    /**
     * Handles all {@link StartElement} events.
     *
     * Behaves just like {@link #handleEvent(XMLEvent)}.
     * Default implementation does nothing.
     *
     * @see #handleEvent(XMLEvent)
     */
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        return this;
    }

    /**
     * Handles all {@link Characters} events.
     *
     * Behaves just like {@link #handleEvent(XMLEvent)}.
     * Default implementation does nothing.
     *
     * @see #handleEvent(XMLEvent)
     */
    protected ParsingContext handleCharacters(Characters characters) throws ParserException {
        return this;
    }

    /**
     * Handles all {@link EndElement} events.
     *
     * Behaves just like {@link #handleEvent(XMLEvent)}.
     * Default implementation does nothing.
     *
     * @see #handleEvent(XMLEvent)
     */
    protected ParsingContext handleEndElement(EndElement endElement) throws ParserException {
        return this;
    }

    /**
     * Handles all {@link XMLEvent}s that are not {@link StartElement}s, {@link Characters} or
     * {@link EndElement}s.
     *
     * Behaves just like {@link #handleEvent(XMLEvent)}.
     * Default implementation does nothing.
     *
     * @see #handleEvent(XMLEvent)
     */
    protected ParsingContext handleUnknownElement(XMLEvent event) throws ParserException {
        // ignore START_DOCUMENT and END_DOCUMENT since these should have no effect anyways
        if (event.getEventType() == XMLEvent.START_DOCUMENT
                && event.getEventType() == XMLEvent.END_DOCUMENT) {
            return this;
        }

        throw new ParserException(
                String.format(
                        "Encountered an unknown element: %d",
                        event.getEventType()
                )
        );
    }

}
