package cn.byteboy.difficulty.easy._226;

import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

/**
 * @author hongshaochuan
 * @Date 2021/7/13
 */
public class InvertBinaryTreeTest extends AbstractTest {

    @Test
    public void test() {
        System.out.println(verify());
    }

    @Override
    protected Object getObj() {
        return new InvertBinaryTree();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/easy/_226"));
    }
}
