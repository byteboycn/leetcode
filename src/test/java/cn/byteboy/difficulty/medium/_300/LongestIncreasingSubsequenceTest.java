package cn.byteboy.difficulty.medium._300;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @date 2021/6/28
 */
public class LongestIncreasingSubsequenceTest extends AbstractTest {

    @Test
    public void test() {
        verify();
    }

    @Override
    protected Object getObj() {
        return new LongestIncreasingSubsequence();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_300"));
    }
}
