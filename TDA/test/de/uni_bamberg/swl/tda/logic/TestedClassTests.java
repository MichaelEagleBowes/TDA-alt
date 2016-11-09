package de.uni_bamberg.swl.tda.logic;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for the class {@link TestedClass}.
 * 
 * @author Nicolas Gross
 *
 */

public class TestedClassTests {

	private static TestedClass testedClass;
	private static List<UnitTest> testList = new LinkedList<>();

	@BeforeClass
	public static void initializeTestClass() throws TdaDataModelException {
		UnitTestResult result1 = new UnitTestResult("r01", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.PASSED, "dir", "tlId",
				"type", "");
		UnitTest unitTest1 = new UnitTest("test1", "unitTest", "storage", "adapter", "codeBase", result1);
		UnitTestResult result2 = new UnitTestResult("r02", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.PASSED, "dir", "tlId",
				"type", "");
		UnitTest unitTest2 = new UnitTest("test2", "unitTest", "storage", "adapter", "codeBase", result2);
		UnitTestResult result3 = new UnitTestResult("r03", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.FAILED, "dir", "tlId",
				"type", "");
		UnitTest unitTest3 = new UnitTest("test3", "unitTest", "storage", "adapter", "codeBase", result3);
		testList.add(unitTest1);
		testList.add(unitTest2);
		testList.add(unitTest3);
	}

	@Before
	public void initializeTests() throws TdaDataModelException {
		testedClass = new TestedClass("TestedClass", testList);
	}

	@Test
	public void setsNameSuccessfully() {
		assertEquals("TestedClass", testedClass.getName());
	}

	@Test
	public void setsListSuccessfully() {
		assertEquals(testList, testedClass.getTestList());
	}

	@Test
	public void calculatesCorrectFailurePercentage() {
		assertEquals(33.33, testedClass.getFailurePercentage(), 0.0);
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyNameIsNotAccepted() throws TdaDataModelException {
		testedClass = new TestedClass("", testList);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsNameIsNotAccepted() throws TdaDataModelException {
		testedClass = new TestedClass(null, testList);
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyTestListIsNotAccepted() throws TdaDataModelException {
		testedClass = new TestedClass("abcd1234", new LinkedList<>());
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsTestListIsNotAccepted() throws TdaDataModelException {
		testedClass = new TestedClass("abcd1234", null);
	}
}
