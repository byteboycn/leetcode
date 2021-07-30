package cn.byteboy.difficulty.hard._293;

import cn.byteboy.core.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hongshaochuan
 * @date 2021/7/31
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
 * 。
 *
 *  返回滑动窗口中的最大值。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 *  示例 2：
 *
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 *  示例 3：
 *
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 *
 *  示例 4：
 *
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 *
 *
 *  示例 5：
 *
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= nums.length <= 105
 *  -104 <= nums[i] <= 104
 *  1 <= k <= nums.length
 *
 *  Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列）
 *  👍 1095 👎 0
 */
public class SlidingWindowMaximum {

    @Solution
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    static class MonotonicQueue {

        private LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) {
            while (!q.isEmpty() && q.getLast() < n)
                q.pollLast();
            q.addLast(n);
        }

        public int max() {
            return q.getFirst();
        }

        // 队头元素如果是 n，删除它
        public void pop(int n) {
            if (q.getFirst() == n)
                q.pollFirst();
        }
    }

}

