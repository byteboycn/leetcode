package cn.byteboy.core;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 18:46
 *
 * 测试用例
 */
public class TestCaseResult {

    private TestCase testCase;

    private Object actual;

    public TestCaseResult(TestCase testCase, Object actual) {
        this.testCase = testCase;
        this.actual = actual;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public Object getActual() {
        return actual;
    }
}
