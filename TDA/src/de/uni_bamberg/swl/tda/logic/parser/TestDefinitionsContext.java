package de.uni_bamberg.swl.tda.logic.parser;

import java.util.List;
import java.util.ArrayList;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

import de.uni_bamberg.swl.tda.logic.TdaDataModelException;
import de.uni_bamberg.swl.tda.logic.TestRun;
import de.uni_bamberg.swl.tda.logic.TestRunBuilder;
import de.uni_bamberg.swl.tda.logic.TestedClass;
import de.uni_bamberg.swl.tda.logic.UnitTestBuilder;
import de.uni_bamberg.swl.tda.logic.TestedClassBuilder;
import de.uni_bamberg.swl.tda.logic.UnitTest;

/**
 * Parses the {@code <TestEntries>} element in the XML.
 * 
 * @author Michael Bowes
 */
public class TestDefinitionsContext extends ParsingContextBase {

	private final ParsingContext parent;
	private final TestRunBuilder rootBuilder;
	
    private final UnitTestBuilder builder = new UnitTestBuilder();
    private final TestedClassBuilder listBuilder = new TestedClassBuilder();
	
    public TestDefinitionsContext(ParsingContext parent, TestRunBuilder builder) {
    	this.parent = parent;
        this.rootBuilder = builder;
    }
	
	/**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleStartElement(StartElement startElement) throws ParserException {
        // <UnitTest>
        if (XMLName.Element.UNIT_TEST.equals(startElement.getName().getLocalPart())) {
            builder.setId(getAttributeOrThrow(startElement, XMLName.Attribute.ID));
            builder.setName(getAttributeOrThrow(startElement, XMLName.Attribute.NAME));
            builder.setStorage(getAttributeOrThrow(startElement, XMLName.Attribute.STORAGE));
        }

        // <TestMethod>
        if (XMLName.Element.TEST_METHOD.equals(startElement.getName().getLocalPart())) {
            builder.setAdapterTypeName(getAttributeOrThrow(startElement, XMLName.Attribute.ADAPTER_TYPE_NAME));
            listBuilder.setName(getAttributeOrThrow(startElement, XMLName.Attribute.CLASS_NAME));
            builder.setCodeBase(getAttributeOrThrow(startElement, XMLName.Attribute.CODE_BASE));
        }

        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected ParsingContext handleEndElement(EndElement endElement) throws ParserException {
        if (XMLName.Element.TEST_DEFINITIONS.equals(endElement.getName().getLocalPart())) {
            // build the settings
            try { List<UnitTest> list = new ArrayList<>();
        		builder.create();
            	rootBuilder.setClassList(new ArrayList<TestedClass>());
            } catch (TdaDataModelException e) {
                throw new ParserException(
                        String.format("Failed to parse '%s' element. " +
                                "The structure was valid, but the contents could not be validated.",
                                XMLName.Element.TEST_DEFINITIONS),
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
                        XMLName.Element.TEST_DEFINITIONS)
        );
    }
}
