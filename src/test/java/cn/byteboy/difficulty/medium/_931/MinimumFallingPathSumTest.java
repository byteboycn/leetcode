package cn.byteboy.difficulty.medium._931;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/6/29
 */
public class MinimumFallingPathSumTest extends AbstractTest {

    @Test
    public void test() {
        verify();
    }

    @Override
    protected Object getObj() {
        return new MinimumFallingPathSum();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_931"));
    }
}
