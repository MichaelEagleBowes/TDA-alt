package de.uni_bamberg.swl.tda.logic.parser;

/**
 * Provides constants for the names of elements and attributes used in the XML schema.
 *
 * @author Florian Beetz
 */
class XMLName {

    public static class Element {
        public static final String TEST_RUN = "TestRun";
        public static final String TEST_SETTINGS = "TestSettings";
        public static final String TIMES = "Times";
        public static final String RESULT_SUMMARY = "ResultSummary";
        public static final String TEST_DEFINITIONS = "TestDefinitions";
        public static final String UNIT_TEST = "UnitTest";
        public static final String EXECUTION = "Execution";
        public static final String TEST_METHOD = "TestMethod";
        public static final String TEST_LISTS = "TestLists";
        public static final String TEST_ENTRIES = "TestEntries";
        public static final String RESULTS = "Results";
        public static final String UNIT_TEST_RESULT = "UnitTestResult";
    }

    public static class Attribute {
        public static final String XMLNS = "xmlns";
        public static final String ID = "id";
        public static final String RUN_USER = "runUser";
        public static final String CREATION = "creation";
        public static final String FINISH = "finish";
        public static final String QUEUEING = "queueing";
        public static final String START = "start";
        public static final String OUTCOME = "outcome";
        public static final String TOTAL = "total";
        public static final String EXECUTED = "executed";
        public static final String PASSED = "passed";
        public static final String FAILED = "failed";
        public static final String NAME = "name";
        public static final String CLASS_NAME = "className";
        public static final String EXECUTION_ID = "executionId";
    }

}
