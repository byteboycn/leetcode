package cn.byteboy.core;

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

        public MethodExecute(Method method, long executeTime) {
            this.method = method;
            this.executeTime = executeTime;
        }

        public boolean isSuccess() {
            return failureCount == 0;
        }

        public String getMethodName() {
            return method.getName();
        }

        public long getExecuteTime() {
            return executeTime;
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
        for (MethodExecute method : methods) {
            sb.append(method.getMethodName())
                    .append("-----").append(isSuccess() ? "success" : "failure").append("-----")
                    .append("cost:").append(method.getExecuteTime()).append("ms");
            sb.append("\n");
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
