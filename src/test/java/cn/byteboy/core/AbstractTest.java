package cn.byteboy.core;

import cn.byteboy.core.converter.*;
import org.junit.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 18:45
 */
public abstract class AbstractTest {

    protected List<TestCase> testCaseList;

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
    }

    /**
     * get the obj to be tested
     */
    protected abstract Object getObj();

    /**
     * load test case
     */
    protected abstract void loadTestCase();

    /**
     * verify all public method, all Object method exclusive
     */
    protected void verify() {
        if (getObj() == null) {
            throw new IllegalArgumentException("the test obj can not be null");
        }
        Arrays.stream(getObj().getClass().getMethods())
                .filter(m -> m.isAnnotationPresent(Solution.class))
                .forEach(this::verify);
    }

    /**
     * verify specified method
     */
    protected void verify(Method method) {
        if (getObj() == null) {
            throw new IllegalArgumentException("the test obj can not be null");
        }
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
                Assert.assertEquals(result, expectedConverter.convert(testCase.getExpected()));
            } catch (Exception e) {
                e.printStackTrace();
            } catch (AssertionError e) {
                throw e;
            }
        }
    }
}
