package de.uni_bamberg.swl.tda;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.uni_bamberg.swl.tda.logic.TestRunTests;
import de.uni_bamberg.swl.tda.logic.TestedClassTests;
import de.uni_bamberg.swl.tda.logic.UnitTestTests;

/**
 * Test suite for all tests.
 * 
 * @author Nicolas Gross
 *
 */

@RunWith(Suite.class)
@SuiteClasses({ UnitTestTests.class, TestedClassTests.class, TestRunTests.class })
public class AllTests {

}
