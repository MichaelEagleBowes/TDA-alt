package de.uni_bamberg.swl.tda.logic.parser;

/**
 * Provides constants for the names of elements and attributes used in the XML schema.
 *
 * @author Florian Beetz AND Michael Bowes
 */
class XMLName {

    public static class Element {
        public static final String TEST_RUN = "TestRun";
        
        public static final String TEST_SETTINGS = "TestSettings";
        // Children of <TestSettings>
        public static final String DEPLOYMENT = "Deployment";
        public static final String EXECUTION = "Execution"; // ALSO Child of <TestDefinitions>
        public static final String TEST_TYPE_SPECIFIC = "TestTypeSpecific"; // Child of <Execution>
        public static final String AGENT_RULE = "AgentRule"; // Child of <Execution>
        public static final String PROPERTIES = "Properties";
        
        public static final String TIMES = "Times";
        
        public static final String RESULT_SUMMARY = "ResultSummary";
        // Children of <ResultSummary>
        public static final String COUNTERS = "Counters";
        public static final String OUTPUT = "Output"; // ALSO Child of <UnitTestResult> (see <Results>)
        public static final String STD_OUT = "StdOut"; // Child of <Output>
        
        public static final String TEST_DEFINITIONS = "TestDefinitions";
        // Children of <TestDefinitions>
        public static final String UNIT_TEST = "UnitTest";
        public static final String TEST_METHOD = "TestMethod";
        
        public static final String TEST_LISTS = "TestLists";
        // Children of <TestLists>
        public static final String TEST_LIST = "TestList";
        
        public static final String TEST_ENTRIES = "TestEntries";
        // Children of <TestEntries>
        public static final String TEST_ENTRY = "TestEntry";
        
        public static final String RESULTS = "Results";
        // Children of <Results>
        public static final String UNIT_TEST_RESULT = "UnitTestResult";
        public static final String ERROR_INFO = "ErrorInfo"; // Child of <Output>
        public static final String MESSAGE = "Message"; // Child of <ErrorInfo>
        public static final String STACK_TRACE = "StackTrace"; // Child of <ErrorInfo>
    }

    public static class Attribute {
        //General
        public static final String ID = "id";
        public static final String NAME = "name";
        //TestRun
        public static final String XMLNS = "xmlns";
        public static final String RUN_USER = "runUser";
        //TestSettings
        public static final String RUN_DEPLOYMENT_ROOT = "runDeploymentRoot";
        public static final String USE_DEFAULT_DEPLOYMENT_ROOT = "useDefaultDeploymentRoot";
        public static final String USER_DEPLOYMENT_ROOT = "userDeploymentRoot";
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
        public static final String PASSED_BUT_RUN_ABORTED = "passedButRunAborted";
        public static final String PENDING = "pending";
        public static final String TIMEOUT = "timeout";
        public static final String TOTAL = "total";
        public static final String WARNING = "warning";
        //TestDefinitions
        public static final String STORAGE = "storage";
        public static final String ADAPTER_TYPE_NAME = "adapterTypeName";
        public static final String CLASS_NAME = "className";
        public static final String CODE_BASE = "codeBase";
        //TestLists
        //TestEntries
        public static final String EXECUTION_ID = "executionId"; // ALSO Child of <Results>
        public static final String TEST_ID = "testId"; // ALSO Child of <Results>
        public static final String TEST_LISTID = "testListId";
        //Results
        public static final String OUTCOME = "outcome";
        public static final String COMPUTER_NAME = "computerName";
        public static final String DATA_ROW_INFO = "dataRowInfo";
        public static final String DURATION = "duration";
        public static final String END_TIME = "endTime";
        public static final String RELATIVE_RESULTS_DIRECTORY = "relativeResultsDirectory";
        public static final String START_TIME = "startTime";
        public static final String TEST_LIST_ID = "testListId";
        public static final String TEST_NAME = "testName";
        public static final String TEST_TYPE = "testType";
    }

}
