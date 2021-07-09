package cn.byteboy.difficulty.hard._72;

import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @date 2021/6/30
 */
public class EditDistanceTest extends AbstractTest {

    @Test
    public void test() {
        verify();
    }

    @Override
    protected Object getObj() {
        return new EditDistance();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/hard/_72"));
    }
}
