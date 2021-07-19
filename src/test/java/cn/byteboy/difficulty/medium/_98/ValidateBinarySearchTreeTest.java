package cn.byteboy.difficulty.medium._98;

import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/7/20
 */
public class ValidateBinarySearchTreeTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new ValidateBinarySearchTree();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_98"));
    }
}
