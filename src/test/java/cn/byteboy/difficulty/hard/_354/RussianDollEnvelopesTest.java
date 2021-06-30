package cn.byteboy.difficulty.hard._354;

import cn.byteboy.core.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @date 2021/6/30
 */
public class RussianDollEnvelopesTest extends AbstractTest {

    @Test
    public void test() {
        verify();
    }

    @Override
    protected Object getObj() {
        return new RussianDollEnvelopes();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/hard/_354"));
    }
}
