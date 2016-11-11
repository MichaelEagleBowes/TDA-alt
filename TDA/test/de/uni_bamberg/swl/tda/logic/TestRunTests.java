package de.uni_bamberg.swl.tda.logic;

import static org.junit.Assert.assertEquals;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for the class {@link TestRun}.
 * 
 * @author Nicolas Gross
 *
 */

public class TestRunTests {

	private static TestRun testRun;
	private static TestRunSetting setting;
	private static TestRunResult result;
	private static List<TestedClass> classList = new LinkedList<>();

	@BeforeClass
	public static void initializeTestClass() throws TdaDataModelException {
		UnitTestResult result1 = new UnitTestResult("r01", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.PASSED, "dir", "tlId",
				"type", "", "");
		UnitTest unitTest1 = new UnitTest("test1", "unitTest", "storage", "adapter", "codeBase", result1);
		UnitTestResult result2 = new UnitTestResult("r02", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.PASSED, "dir", "tlId",
				"type", "", "");
		UnitTest unitTest2 = new UnitTest("test2", "unitTest", "storage", "adapter", "codeBase", result2);
		UnitTestResult result3 = new UnitTestResult("r03", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.FAILED, "dir", "tlId",
				"type", "", "");
		UnitTest unitTest3 = new UnitTest("test3", "unitTest", "storage", "adapter", "codeBase", result3);
		UnitTestResult result4 = new UnitTestResult("r04", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.PASSED, "dir", "tlId",
				"type", "", "");
		UnitTest unitTest4 = new UnitTest("test4", "unitTest", "storage", "adapter", "codeBase", result4);
		UnitTestResult result5 = new UnitTestResult("r05", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.FAILED, "dir", "tlId",
				"type", "", "");
		UnitTest unitTest5 = new UnitTest("test5", "unitTest", "storage", "adapter", "codeBase", result5);
		UnitTestResult result6 = new UnitTestResult("r06", "computer", "row", "00:00:01",
				"2016-09-21T13:37:43.7071946+02:00", "2016-09-21T13:37:44.7071946+02:00", Outcome.FAILED, "dir", "tlId",
				"type", "", "");
		UnitTest unitTest6 = new UnitTest("test6", "unitTest", "storage", "adapter", "codeBase", result6);
		List<UnitTest> testList1 = new LinkedList<>();
		List<UnitTest> testList2 = new LinkedList<>();
		testList1.add(unitTest1);
		testList1.add(unitTest2);
		testList1.add(unitTest3);
		testList2.add(unitTest4);
		testList2.add(unitTest5);
		testList2.add(unitTest6);
		TestedClass testedClass1 = new TestedClass("TestedClass1", testList1);
		TestedClass testedClass2 = new TestedClass("TestedClass2", testList2);
		classList.add(testedClass1);
		classList.add(testedClass2);
	}

	@Before
	public void initializeTests() throws TdaDataModelException {
		setting = new TestRunSetting("trs1", "Setting", "rundepl", false, "userdepl", "agentRuleName");
		result = new TestRunResult(Outcome.FAILED, 0, 0, 0, 0, 6, 3, 0, 0, 0, 0, 3, 0, 0, 0, 6, 0);
		testRun = new TestRun("xmlns", "TR1", "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", classList, setting, result);
	}

	@Test
	public void setsIdSuccessfully() {
		assertEquals("TR1", testRun.getId());
	}

	@Test
	public void setsCorrectDateSuccessfully() {
		String dateAsString = "2015-11-26T11:38:43.707194632+01:00";
		ZonedDateTime date = ZonedDateTime.parse(dateAsString);
		assertEquals(date, testRun.getCreationDate());
	}

	@Test(expected = TdaDataModelException.class)
	public void wrongDateFormatIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("xmlns", "TR1", "testRun1", "Fred", "2015-11-26T11:38:43.707194632",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", classList, setting, result);
	}

	@Test
	public void setsOutcomeSuccessfully() {
		assertEquals(Outcome.FAILED, testRun.getResult().getOutcome());
	}

	@Test
	public void setsClassListSuccessfully() {
		assertEquals(classList, testRun.getCLassList());
	}

	@Test
	public void requestOfValidClassNameWorks() throws TdaDataModelException {
		assertEquals("TestedClass1", testRun.getTestedClass("TestedClass1").getName());
	}

	@Test(expected = TdaDataModelException.class)
	public void requestOfInvalidClassNameThrowsException() throws TdaDataModelException {
		testRun.getTestedClass("TestedClass3");
	}

	@Test
	public void setsResultSuccessfully() {
		assertEquals(6, testRun.getResult().getTotal());
		assertEquals(6, testRun.getResult().getExecuted());
		assertEquals(3, testRun.getResult().getPassed());
		assertEquals(3, testRun.getResult().getFailed());
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyIdIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("xmlns", "", "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", classList, setting, result);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsIdIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("xmlns", null, "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", classList, setting, result);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsOutcomeIsNotAccepted() throws TdaDataModelException {
		result = new TestRunResult(null, 0, 0, 0, 0, 6, 3, 0, 0, 0, 0, 3, 0, 0, 0, 6, 0);
		testRun = new TestRun("xmlns", "TR1", "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", classList, setting, result);
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyClassListIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("xmlns", "TR1", "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", new LinkedList<>(), setting, result);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsClassListIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("xmlns", "TR1", "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", null, setting, result);
	}

	@Test(expected = TdaDataModelException.class)
	public void zeroAsTotalTestsIsNotAccepted() throws TdaDataModelException {
		result = new TestRunResult(Outcome.FAILED, 0, 0, 0, 0, 6, 3, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0);
		testRun = new TestRun("xmlns", "TR1", "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", classList, setting, result);
	}

	@Test(expected = TdaDataModelException.class)
	public void negativeNumberAsCounterIsNotAccepted() throws TdaDataModelException {
		result = new TestRunResult(Outcome.FAILED, 0, 0, 0, 0, 6, 3, -1, 0, 0, 0, 3, 0, 0, 0, 6, 0);
		testRun = new TestRun("xmlns", "TR1", "testRun1", "Fred", "2015-11-26T11:38:43.707194632+01:00",
				"2015-11-26T13:38:43.707194632+01:00", "2015-11-26T13:38:40.707194632+01:00",
				"2015-11-26T13:38:42.707194632+01:00", classList, setting, result);
	}
}
