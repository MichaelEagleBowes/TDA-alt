package de.uni_bamberg.swl.tda.parser;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.events.StartElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link XMLUtilities}
 *
 * @author Florian Beetz
 */
public class XMLUtilitiesTest extends XMLUtilities {

    private static final XMLEventFactory FACTORY = XMLEventFactory.newFactory();

    private static final String ELEMENT_NAME = "test";
    private static final String ATTRIBUTE_NAME = "attribute";
    private static final String ATTRIBUTE_VALUE = "123";

    private StartElement element;

    @Before
    public void setupStartElement(){
        element = FACTORY.createStartElement(
                new QName(ELEMENT_NAME),
                Collections.singletonList(
                        FACTORY.createAttribute(new QName(ATTRIBUTE_NAME), ATTRIBUTE_VALUE)
                ).iterator(),
                null
        );
    }

    @Test
    public void testGetAttribute() {
        assertTrue(getAttribute(element, ATTRIBUTE_NAME).isPresent());
    }

    @Test
    public void testGetAttributeNotExists() {
        assertFalse(getAttribute(element, "doesNotExist").isPresent());
    }

    @Test
    public void testGetAttributeOrThrow() throws ParserException {
        getAttributeOrThrow(element, ATTRIBUTE_NAME);
    }

    @Test(expected = ParserException.class)
    public void testGetAttributeOrThrowNotExists() throws ParserException {
        getAttributeOrThrow(element, "doesNotExist");
    }
}