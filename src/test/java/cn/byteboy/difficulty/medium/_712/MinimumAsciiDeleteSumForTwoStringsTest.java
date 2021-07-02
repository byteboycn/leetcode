package cn.byteboy.difficulty.medium._712;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/7/2
 */
public class MinimumAsciiDeleteSumForTwoStringsTest extends AbstractTest {


    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new MinimumAsciiDeleteSumForTwoStrings();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_712"));
    }
}
