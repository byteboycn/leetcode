package cn.byteboy.difficulty.medium._95;

import cn.byteboy.core.converter.TreeNodeTypeConverter;
import cn.byteboy.core.model.TreeNode;
import cn.byteboy.core.test.AbstractTest;
import org.junit.Test;

import java.util.List;

/**
 * @author hongshaochuan
 * @Date 2021/7/20
 */
public class UniqueBinarySearchTreesIiTest extends AbstractTest {

    @Test
    public void test() {
        List<TreeNode> nodeList = new UniqueBinarySearchTreesIi().generateTrees(3);
        for (TreeNode treeNode : nodeList) {
            System.out.println(TreeNodeTypeConverter.INSTANCE.reverse(treeNode));
        }
    }

    @Override
    protected Object getObj() {
        return new UniqueBinarySearchTreesIi();
    }

    @Override
    protected void loadTestCase() {
        testCaseList.addAll(testCaseScanner.read("TestCases/difficulty/medium/_95"));
    }
}
