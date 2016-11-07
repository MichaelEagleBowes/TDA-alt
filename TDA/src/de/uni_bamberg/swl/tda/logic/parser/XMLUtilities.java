package de.uni_bamberg.swl.tda.logic.parser;

import java.util.Optional;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;

/**
 * Provides some utility methods for dealing with XML.
 *
 * @author Florian Beetz
 */
class XMLUtilities {

    /**
     * Returns an {@link Optional<String>} of the value of an attribute on an element.
     */
    protected Optional<String> getAttribute(StartElement element, String name) {
        Attribute attribute = element.getAttributeByName(new QName(name));

        return Optional.ofNullable(attribute).map(Attribute::getValue);
    }

    /**
     * Returns the value of an attribute on an element or throws a {@link ParserException} with the
     * given message.
     */
    protected String getAttributeOrThrow(StartElement element, String name, String message)
            throws ParserException {
        return getAttribute(element, name).orElseThrow(() -> new ParserException(message));
    }


    /**
     * Returns the value of an attribute on an element or throws a {@link ParserException} with an
     * error message.
     */
    protected String getAttributeOrThrow(StartElement element, String name) throws ParserException {
        String message = String.format(
                "Expected attribute '%s' on element '%s' is not present in XML.",
                element.getName().getLocalPart(),
                name
        );

        return getAttributeOrThrow(element, name, message);
    }

}
