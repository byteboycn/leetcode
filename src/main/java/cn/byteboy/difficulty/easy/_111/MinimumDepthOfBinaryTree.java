package cn.byteboy.difficulty.easy._111;

import cn.byteboy.core.Solution;
import cn.byteboy.core.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hongshaochuan
 * @date 2021/8/11
 *
 * Given a binary tree, find its minimum depth.
 *
 *  The minimum depth is the number of nodes along the shortest path from the roo
 * t node down to the nearest leaf node.
 *
 *  Note: A leaf is a node with no children.
 *
 *
 *  Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 *
 *  Example 2:
 *
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 *
 *  Constraints:
 *
 *
 *  The number of nodes in the tree is in the range [0, 105].
 *  -1000 <= Node.val <= 1000
 *
 *  Related Topics Tree Depth-First Search Breadth-First Search Binary Tree
 *  👍 2831 👎 850
 */
public class MinimumDepthOfBinaryTree {

    @Solution
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null)
                    return depth;
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);

            }
            depth++;
        }
        return depth;
    }
}
