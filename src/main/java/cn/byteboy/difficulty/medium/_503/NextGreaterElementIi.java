package cn.byteboy.difficulty.medium._503;

import cn.byteboy.core.Solution;

import java.util.Stack;

/**
 * @author hongshaochuan
 * @date 2021/7/30
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
 * 一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 *  示例 1:
 *
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 *
 *  注意: 输入数组的长度不会超过 10000。
 *  Related Topics 栈 数组 单调栈
 *  👍 458 👎 0
 */
public class NextGreaterElementIi {

    @Solution
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        // 由于是循环数组，所以模拟将数组翻倍
        for (int i = 2 * n - 1; i >= 0 ; i--) {
            // stack.peek() 相当于是 i 后面数字
            while (!stack.empty() && stack.peek() <= nums[i % n])
                stack.pop();
            res[i % n] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }

}
