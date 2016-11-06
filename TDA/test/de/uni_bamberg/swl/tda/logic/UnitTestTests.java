package de.uni_bamberg.swl.tda.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the class {@link UnitTest}.
 * 
 * @author Nicolas Gross
 *
 */

public class UnitTestTests {

	private UnitTest unitTest;

	@Before
	public void initializeTests() throws TdaDataModelException {
		unitTest = new UnitTest("abcd1234", "TestName", Outcome.PASSED);
	}

	@Test
	public void setsIdSuccessfully() {
		assertEquals("abcd1234", unitTest.getId());
	}

	@Test
	public void setsNameSuccessfully() {
		assertEquals("TestName", unitTest.getName());
	}

	@Test
	public void setsOutcomeSuccessfully() {
		assertEquals(Outcome.PASSED, unitTest.getOutcome());
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyIdIsNotAccepted() throws TdaDataModelException {
		unitTest = new UnitTest("", "TestName");
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsIdIsNotAccepted() throws TdaDataModelException {
		unitTest = new UnitTest(null, "TestName");
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyNameIsNotAccepted() throws TdaDataModelException {
		unitTest = new UnitTest("abcd1234", "");
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsNameIsNotAccepted() throws TdaDataModelException {
		unitTest = new UnitTest("abcd1234", null);
	}
}
