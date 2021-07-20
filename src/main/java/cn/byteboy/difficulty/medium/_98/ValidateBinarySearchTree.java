package cn.byteboy.difficulty.medium._98;

import cn.byteboy.core.Solution;
import cn.byteboy.core.converter.TreeNodeTypeConverter;
import cn.byteboy.core.model.TreeNode;

/**
 * @author hongshaochuan
 * @Date 2021/7/20
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 *  假设一个二叉搜索树具有如下特征：
 *
 *
 *  节点的左子树只包含小于当前节点的数。
 *  节点的右子树只包含大于当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 *  示例 1:
 *
 *  输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 *
 *  示例 2:
 *
 *  输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *  Related Topics 树 深度优先搜索 二叉搜索树 二叉树
 *  👍 1133 👎 0
 */
public class ValidateBinarySearchTree {

    @Solution
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    // 以当前root节点为基准，与父节点比较 且满足 min < root < max
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null)
            return true;
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

}
