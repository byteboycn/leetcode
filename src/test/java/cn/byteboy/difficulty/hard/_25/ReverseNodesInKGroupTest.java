package cn.byteboy.difficulty.hard._25;

import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @date 2021/7/10
 */
public class ReverseNodesInKGroupTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new ReverseNodesInKGroup();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/hard/_25"));
    }
}
