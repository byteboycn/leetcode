package cn.byteboy.difficulty.easy._53;

import cn.byteboy.core.AbstractTest;

/**
 * @author hongshaochuan
 * @date 2021/6/30
 */
public class MaximumSubarrayTest extends AbstractTest {

    @Override
    protected Object getObj() {
        return new MaximumSubarray();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/easy/_53"));
    }
}
