package cn.byteboy.difficulty.easy._226;

import cn.byteboy.core.Solution;
import cn.byteboy.core.converter.TreeNodeTypeConverter;
import cn.byteboy.core.model.TreeNode;

/**
 * @author hongshaochuan
 * @Date 2021/7/13
 *
 * 翻转一棵二叉树。
 *
 *  示例：
 *
 *  输入：
 *
 *       4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 *  输出：
 *
 *       4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 *  谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *  Related Topics 树 深度优先搜索 广度优先搜索 二叉树
 *  👍 912 👎 0
 */
public class InvertBinaryTree {


    @Solution
    public TreeNode invertTree(TreeNode root) {
        pre(root);
        return root;
    }

    private void pre(TreeNode node) {
        if (node == null)
            return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        pre(node.left);
        pre(node.right);
    }

}
