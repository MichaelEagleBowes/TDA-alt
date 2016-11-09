import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.uni_bamberg.swl.tda.logic.TestRunTests;
import de.uni_bamberg.swl.tda.logic.TestedClassTests;
import de.uni_bamberg.swl.tda.logic.UnitTestTests;
import de.uni_bamberg.swl.tda.logic.parser.XMLUtilitiesTest;

/**
 * Test suite for all tests.
 * 
 * @author Nicolas Gross
 *
 */

@RunWith(Suite.class)
@SuiteClasses({
        // logic model
        UnitTestTests.class, TestedClassTests.class, TestRunTests.class,

        // logic parser
        XMLUtilitiesTest.class,
})
public class AllTests {

}
