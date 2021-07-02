package cn.byteboy.difficulty.medium._516;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/7/2
 */
public class LongestPalindromicSubsequenceTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new LongestPalindromicSubsequence();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_516"));
    }
}
