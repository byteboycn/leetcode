package cn.byteboy.difficulty.medium._92;

import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @date 2021/7/9
 */
public class ReverseLinkedListIiTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new ReverseLinkedListIi();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_92"));
    }
}
