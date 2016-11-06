package de.uni_bamberg.swl.tda.logic;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
	private static List<TestedClass> classList = new LinkedList<>();

	@BeforeClass
	public static void initializeTestClass() throws TdaDataModelException {
		UnitTest unitTest1 = new UnitTest("1", "Eins", Outcome.PASSED);
		UnitTest unitTest2 = new UnitTest("2", "Zwei", Outcome.PASSED);
		UnitTest unitTest3 = new UnitTest("3", "Drei", Outcome.FAILED);
		UnitTest unitTest4 = new UnitTest("4", "Vier", Outcome.PASSED);
		UnitTest unitTest5 = new UnitTest("5", "Fuenf", Outcome.FAILED);
		UnitTest unitTest6 = new UnitTest("6", "Sechs", Outcome.FAILED);
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
		testRun = new TestRun("TR1", "2015-11-26T13:38:43.707194632+01:00", Outcome.FAILED, classList, 6, 6, 3, 3);
	}

	@Test
	public void setsIdSuccessfully() {
		assertEquals("TR1", testRun.getId());
	}

	@Test
	public void setsCorrectDateSuccessfully() {
		String dateAsString = "2015-11-26T13:38:43.707194632+01:00";
		Instant instant = Instant.parse(dateAsString.substring(0, dateAsString.length() - 6) + "Z");
		LocalDateTime date = LocalDateTime.ofInstant(instant,
				ZoneOffset.of((dateAsString.substring(dateAsString.length() - 6, dateAsString.length()))));
		assertEquals(date, testRun.getCreationDate());
	}

	@Test(expected = TdaDataModelException.class)
	public void wrongDateFormatIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("TR1", "2015-11-26T13:38:43.707194632", Outcome.FAILED, classList, 6, 6, 3, 3);
	}

	@Test
	public void setsOutcomeSuccessfully() {
		assertEquals(Outcome.FAILED, testRun.getOutcome());
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
	public void setsCounterSuccessfully() {
		assertEquals(6, testRun.getCounter().getTotalTests());
		assertEquals(6, testRun.getCounter().getExecutedTests());
		assertEquals(3, testRun.getCounter().getPassedTests());
		assertEquals(3, testRun.getCounter().getFailedTests());
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyIdIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("", "2015-11-26T13:38:43.707194632", Outcome.FAILED, classList, 6, 6, 3, 3);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsIdIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun(null, "2015-11-26T13:38:43.707194632", Outcome.FAILED, classList, 6, 6, 3, 3);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsOutcomeIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("TR1", "2015-11-26T13:38:43.707194632", null, classList, 6, 6, 3, 3);
	}

	@Test(expected = TdaDataModelException.class)
	public void emptyClassListIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("TR1", "2015-11-26T13:38:43.707194632+01:00", Outcome.FAILED, new LinkedList<>(), 6, 6, 3,
				3);
	}

	@Test(expected = TdaDataModelException.class)
	public void nullAsClassListIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("TR1", "2015-11-26T13:38:43.707194632+01:00", Outcome.FAILED, null, 6, 6, 3, 3);
	}

	@Test(expected = TdaDataModelException.class)
	public void zeroAsTotalTestsIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("TR1", "2015-11-26T13:38:43.707194632", Outcome.FAILED, classList, 0, 6, 3, 3);
	}

	@Test(expected = TdaDataModelException.class)
	public void negativeNumberAsCounterIsNotAccepted() throws TdaDataModelException {
		testRun = new TestRun("TR1", "2015-11-26T13:38:43.707194632", Outcome.FAILED, classList, 6, -1, 3, 3);
	}
}
