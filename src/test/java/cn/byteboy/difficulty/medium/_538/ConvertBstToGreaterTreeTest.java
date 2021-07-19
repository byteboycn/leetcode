package cn.byteboy.difficulty.medium._538;

import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/7/19
 */
public class ConvertBstToGreaterTreeTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new ConvertBstToGreaterTree();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_538"));
    }
}
