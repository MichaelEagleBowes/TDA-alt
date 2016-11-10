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
        //General
        public static final String ID = "id";
        public static final String NAME = "name";
        //TestRun
        public static final String XMLNS = "xmlns";
        public static final String RUN_USER = "runUser";
        //TestSettings
        public static final String RUN_DEPLOYMENTROOT = "runDeploymentRoot";
        public static final String USE_DEFAULTDEPLOYMENTROOT = "useDefaultDeploymentRoot";
        public static final String USER_DEPLOYMENTROOT = "userDeploymentRoot";
        //Times
        public static final String CREATION = "creation";
        public static final String FINISH = "finish";
        public static final String QUEUEING = "queueing";
        public static final String START = "start";
        //ResultSummary
        public static final String ABORTED = "aborted";
        public static final String COMPLETED = "completed";
        public static final String DISCONNECTED = "disconnected";
        public static final String ERROR = "error";
        public static final String EXECUTED = "executed";
        public static final String FAILED = "failed";
        public static final String IN_PROGRESS = "inProgress";
        public static final String INCONCLUSIVE = "inconclusive";
        public static final String NOT_EXECUTED = "notExecuted";
        public static final String NOT_RUNNABLE = "notRunnable";
        public static final String PASSED = "passed";
        public static final String PASSED_BUTRUNABORTED = "passedButRunAborted";
        public static final String PENDING = "pending";
        public static final String TIMEOUT = "timeout";
        public static final String TOTAL = "total";
        public static final String WARNING = "warning";
        //TestDefinitions
        public static final String STORAGE = "storage";
        public static final String ADAPTER_TYPENAME"adapterTypeName";
        public static final String CLASS_NAME = "className";
        public static final String CODEBASE = "codeBase";
        //TestLists
        //TestEntries
        public static final String EXECUTION_ID = "executionId";
        public static final String TEST_ID = "testId";
        public static final String TEST_LISTID = "testListId";
        //Results
        public static final String OUTCOME = "outcome";
        public static final String COMPUTER_NAME = "computerName";
        public static final String DATA_ROWINFO = "dataRowInfo";
        public static final String DURATION = "duration";
        public static final String ENDTIME = "endTime";
        public static final String EXECUTION_ID = "executionId";
        public static final String RELATIVE_RESULTSDIRECTORY = "relativeResultsDirectory";
        public static final String START_TIME = "startTime";
        public static final String TEST_ID = "testId";
        public static final String TEST_LISTID = "testListId";
        public static final String TEST_NAME = "testName";
        public static final String TEST_TYPE = "testType";
    }

}
