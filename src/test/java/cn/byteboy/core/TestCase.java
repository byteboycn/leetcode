package cn.byteboy.core;

/**
 * @author Hong Shaochuan
 * @email xhhsc@outlook.com
 * @date 2020/8/16 18:46
 *
 * 测试用例
 */
public class TestCase {

    private String expected;

    private String[] input;

    public TestCase() {
    }

    public TestCase(String expected, String... input) {
        this.expected = expected;
        this.input = input;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String[] getInput() {
        return input;
    }

    public void setInput(String[] input) {
        this.input = input;
    }
}
