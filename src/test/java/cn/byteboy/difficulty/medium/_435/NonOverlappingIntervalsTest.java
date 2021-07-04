package cn.byteboy.difficulty.medium._435;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @date 2021/7/3
 */
public class NonOverlappingIntervalsTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new NonOverlappingIntervals();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_435"));
    }
}
