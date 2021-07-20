package cn.byteboy.difficulty.medium._95;

import cn.byteboy.core.Solution;
import cn.byteboy.core.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hongshaochuan
 * @Date 2021/7/20
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 *
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 *
 *  示例 2：
 *
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= n <= 8
 *
 *
 *
 *  Related Topics 树 二叉搜索树 动态规划 回溯 二叉树
 *  👍 936 👎 0
 */
public class UniqueBinarySearchTreesIi {



    @Solution
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int l, int h) {
        List<TreeNode> res = new LinkedList<>();
        if (l > h) {
            res.add(null);
            return res;
        }

        for (int i = l; i <= h; i++) {
            List<TreeNode> left = build(l, i - 1);
            List<TreeNode> right = build(i + 1, h);
            for (TreeNode lT : left) {
                for (TreeNode rT : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lT;
                    root.right = rT;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
