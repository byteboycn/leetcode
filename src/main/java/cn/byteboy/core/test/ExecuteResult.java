package cn.byteboy.core.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongshaochuan
 * @Date 2021/6/29
 */
public class ExecuteResult {

    private int testCaseCount;

    // ms
    private long timeLimit;

    private List<MethodExecute> methods;

    public ExecuteResult(int testCaseCount, long timeLimit) {
        this.testCaseCount = testCaseCount;
        this.timeLimit = timeLimit;
        methods = new ArrayList<>();
    }

    public ExecuteResult add(MethodExecute methodExecute) {
        methods.add(methodExecute);
        return this;
    }

    static class MethodExecute {
        private Method method;

        private String methodName;

        private int successCount;

        private int failureCount;

        private long executeTime;

        private final List<TestCaseResult> failureTestCaseList;

        public MethodExecute(Method method) {
            this.method = method;
            this.failureTestCaseList = new ArrayList<>();
        }

        public void addFailureTestCase(TestCaseResult testCase) {
            failureTestCaseList.add(testCase);
        }

        public boolean isSuccess() {
            return failureTestCaseList.size() == 0;
        }

        public String getMethodName() {
            return method.getName();
        }

        public long getExecuteTime() {
            return executeTime;
        }

        public void setExecuteTime(long executeTime) {
            this.executeTime = executeTime;
        }

        public List<TestCaseResult> getFailureTestCaseList() {
            return failureTestCaseList;
        }
    }

    public boolean isSuccess() {
        for (MethodExecute method : methods) {
            if (!method.isSuccess()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(isSuccess() ? "success" : "failure").append("\n");
        sb.append("test case count:").append(testCaseCount).append("\n");
        for (MethodExecute method : methods) {
            sb.append(method.getMethodName())
                    .append("-----").append(isSuccess() ? "success" : "failure").append("-----")
                    .append("cost:").append(method.getExecuteTime()).append("ms");
            sb.append("\n");
            if (!method.isSuccess()) {
                List<TestCaseResult> list = method.getFailureTestCaseList();
                for (TestCaseResult testCase : list) {
                    sb.append("--------------\n");
                    for (String s : testCase.getTestCase().getInput()) {
                        sb.append("parameter:").append(s).append("\n");
                    }
                    sb.append("Expected:").append(testCase.getTestCase().getExpected()).append("\n");
                    sb.append("Actual:").append(testCase.getActual()).append("\n");
                }
            }
        }

        return sb.toString();
    }

    public int getTestCaseCount() {
        return testCaseCount;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public List<MethodExecute> getMethods() {
        return methods;
    }
}
