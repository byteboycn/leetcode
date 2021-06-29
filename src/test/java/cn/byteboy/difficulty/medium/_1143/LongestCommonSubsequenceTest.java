package cn.byteboy.difficulty.medium._1143;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/6/29
 */
public class LongestCommonSubsequenceTest extends AbstractTest {

    @Test
    public void test() {
        verify();
    }

    @Override
    protected Object getObj() {
        return new LongestCommonSubsequence();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_1143"));
    }
}
