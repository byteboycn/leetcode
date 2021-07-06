package cn.byteboy.core;

import cn.byteboy.core.converter.*;
import org.junit.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 18:45
 */
public abstract class AbstractTest {

    protected List<TestCase> testCaseList;

    // 3000ms
    protected long timeLimit = 3000;

    protected TestCaseScanner testCaseScanner = new DefaultTestCaseScanner();

    public AbstractTest() {
        this(null);
    }

    public AbstractTest(List<TestCase> testCaseList) {
        if (testCaseList == null) {
            this.testCaseList = new ArrayList<>();
        } else {
            this.testCaseList = testCaseList;
        }
        loadTestCase();
        // register type converter
        new IntArrayTypeConverter().register();
        new IntTypeConverter().register();
        new Int2ArrayTypeConverter().register();
        new BooleanTypeConverter().register();
        new StringTypeConverter().register();
    }

    /**
     * get the obj to be tested
     */
    protected abstract Object getObj();

    /**
     * load test case
     */
    protected abstract void loadTestCase();

    protected ExecuteResult merge(ExecuteResult result1, ExecuteResult result2) {
        if (result1 == null && result2 == null) {
            return null;
        }
        if (result1 == null) {
            return result2;
        }
        if (result2 == null) {
            return result1;
        }
        for (ExecuteResult.MethodExecute method : result2.getMethods()) {
            result1.add(method);
        }
        return result1;
    }

    /**
     * verify
     */
    protected ExecuteResult verify() {
        if (getObj() == null) {
            throw new IllegalArgumentException("the test obj can not be null");
        }


        List<Method> methods = Arrays.stream(getObj().getClass().getMethods())
                .filter(m -> m.isAnnotationPresent(Solution.class))
                .collect(Collectors.toList());

        ExecuteResult executeResult = null;

        for (Method method : methods) {
            executeResult = merge(executeResult, verify(method));
        }

        return executeResult;
    }

    /**
     * verify specified method
     */
    protected ExecuteResult verify(Method method) {
        if (getObj() == null) {
            throw new IllegalArgumentException("the test obj can not be null");
        }
        ExecuteResult executeResult = new ExecuteResult(testCaseList.size(), timeLimit);
        ExecuteResult.MethodExecute methodExecute = new ExecuteResult.MethodExecute(method);
        long start = System.currentTimeMillis();
        for (TestCase testCase : testCaseList) {
            try {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Object[] parameterObjs = new Object[parameterTypes.length];
                if (testCase.getInput().length != parameterTypes.length) {
                    throw new IllegalArgumentException("the test case parameter error");
                }
                for (int i = 0; i < parameterTypes.length; i++) {
                    parameterObjs[i] = TypeConverterFactory.getStrategy(parameterTypes[i]).convert(testCase.getInput()[i]);
                }
                Object result = method.invoke(getObj(), parameterObjs);
                TypeConverter<?> expectedConverter = TypeConverterFactory.getStrategy(method.getReturnType());

                if (!Objects.equals(result, expectedConverter.convert(testCase.getExpected()))) {
                    methodExecute.addFailureTestCase(new TestCaseResult(testCase, result));
                }
//                Assert.assertEquals(expectedConverter.convert(testCase.getExpected()), result);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (AssertionError e) {
                throw e;
            }
        }
        long end = System.currentTimeMillis();
        methodExecute.setExecuteTime(end - start);
        executeResult.add(methodExecute);

        return executeResult;
    }
}
