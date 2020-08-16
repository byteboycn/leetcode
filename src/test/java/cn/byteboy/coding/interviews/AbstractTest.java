package cn.byteboy.coding.interviews;

import cn.byteboy.coding.interviews.converter.IntArrayTypeConverter;
import cn.byteboy.coding.interviews.converter.IntTypeConverter;
import cn.byteboy.coding.interviews.converter.TypeConverter;
import cn.byteboy.coding.interviews.converter.TypeConverterFactory;
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
    }

    /**
     * get the obj to be tested
     */
    abstract Object getObj();

    /**
     * load test case
     */
    abstract void loadTestCase();

    /**
     * verify all public method, all Object method exclusive
     */
    protected void verify() {
        Arrays.stream(getObj().getClass().getMethods())
                .filter(m ->  !Arrays.asList(Object.class.getMethods()).contains(m))
                .forEach(this::verify);
    }

    /**
     * verify specified method
     *
     * 目前只能验证只有一个参数的函数
     */
    protected void verify(Method method) {
        for (TestCase testCase : testCaseList) {
            try {
                TypeConverter<?> inputConverter = TypeConverterFactory.getStrategy(method.getParameterTypes()[0]);
                Object result = method.invoke(getObj(), inputConverter.convert(testCase.getInput()));
                TypeConverter<?> expectedConverter = TypeConverterFactory.getStrategy(method.getReturnType());
                Assert.assertEquals(result, expectedConverter.convert(testCase.getExpected()));
            } catch (Exception e) {
                e.printStackTrace();
            } catch (AssertionError e) {
                System.out.println(method.getName());
                throw e;
            }
        }
    }
}
