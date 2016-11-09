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
	private UnitTestResult result;

	@Before
	public void initializeTests() throws TdaDataModelException {
		result = new UnitTestResult("r01", "computer", "row", "00:00:01", "2016-09-21T13:37:43.7071946+02:00",
				"2016-09-21T13:37:44.7071946+02:00", Outcome.PASSED, "dir", "tlId", "type", "");
		unitTest = new UnitTest("abcd1234", "unitTest", "storage", "adapter", "codeBase", result);
	}

	@Test
	public void setsIdSuccessfully() {
		assertEquals("abcd1234", unitTest.getId());
	}

	@Test
	public void setsNameSuccessfully() {
		assertEquals("unitTest", unitTest.getName());
	}

	@Test
	public void setsOutcomeSuccessfully() {
		assertEquals(Outcome.PASSED, unitTest.getResult().getOutcome());
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyIdIsNotAccepted() throws TdaDataModelException {
		unitTest = new UnitTest("", "unitTest", "storage", "adapter", "codeBase", result);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsIdIsNotAccepted() throws TdaDataModelException {
		unitTest = new UnitTest(null, "unitTest", "storage", "adapter", "codeBase", result);
	}

	@Test(expected = TdaDataModelException.class)
	public void invalidResultIsNotAccepted() throws TdaDataModelException {
		result = new UnitTestResult("r01", "computer", "row", "00:00:01", "2016-09-21T13:37:43.7071946",
				"2016-09-21T13:37:44.7071946+02:00", Outcome.PASSED, "dir", "tlId", "type", "");
		unitTest = new UnitTest("abcd1234", "unitTest", "storage", "adapter", "codeBase", result);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsResultIsNotAccepted() throws TdaDataModelException {
		unitTest = new UnitTest("abcd1234", "unitTest", "storage", "adapter", "codeBase", null);
	}
}
