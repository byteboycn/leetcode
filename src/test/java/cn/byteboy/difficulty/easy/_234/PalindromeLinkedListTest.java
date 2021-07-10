package cn.byteboy.difficulty.easy._234;

import cn.byteboy.core.Solution;
import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @date 2021/7/11
 */
public class PalindromeLinkedListTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new PalindromeLinkedList();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/easy/_234"));
    }
}
