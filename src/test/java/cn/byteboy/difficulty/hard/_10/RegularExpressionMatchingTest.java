package cn.byteboy.difficulty.hard._10;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/7/5
 */
public class RegularExpressionMatchingTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new RegularExpressionMatching();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/hard/_10"));
    }
}
