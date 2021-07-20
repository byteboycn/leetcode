package cn.byteboy.difficulty.hard._1373;

import cn.byteboy.core.Solution;
import cn.byteboy.core.model.TreeNode;

/**
 * @author hongshaochuan
 * @Date 2021/7/20
 *
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 *  二叉搜索树的定义如下：
 *
 *
 *  任意节点的左子树中的键值都 小于 此节点的键值。
 *  任意节点的右子树中的键值都 大于 此节点的键值。
 *  任意节点的左子树和右子树都是二叉搜索树。
 *
 *
 *
 *
 *  示例 1：
 *
 *
 *
 *
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 *
 *
 *  示例 2：
 *
 *
 *
 *
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 *
 *
 *  示例 3：
 *
 *
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 *
 *
 *  示例 4：
 *
 *
 * 输入：root = [2,1,3]
 * 输出：6
 *
 *
 *  示例 5：
 *
 *
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 *
 *
 *
 *
 *  提示：
 *
 *
 *  每棵树有 1 到 40000 个节点。
 *  每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 *
 *  Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树
 *  👍 51 👎 0
 */
public class MaximumSumBstInBinaryTree {

    private int maxSum = Integer.MIN_VALUE;

    @Solution
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return Math.max(0, maxSum);
    }

    // 返回当前节点的几个维度信息 int[]{ isBST, min, max, sum}
    private int[] traverse(TreeNode root) {

        if (root == null)
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left =  traverse(root.left);
        int[] right = traverse(root.right);

        int isBST = left[0] == 0 && right[0] == 0     // 左右子树都是BST
                && root.val > left[2]
                && root.val < right[1]
                ? 0 : -1;
        // 当前节点作为其他节点的左子树时，min取当前树的最大节点值
        int min = Math.max(right[2], root.val);
        // 当前节点作为其他节点的右子树时，max取当前树的做小节点值
        int max = Math.min(left[1], root.val);
        int sum = left[3] + right[3] + root.val;

        if (isBST == 0)
            maxSum = Math.max(maxSum, sum);

        return new int[]{isBST, min, max, sum};
    }
}
