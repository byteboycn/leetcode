package cn.byteboy.difficulty.hard._410;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @date 2021/7/27
 *
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 *  设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 *  示例 2：
 *
 *
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 *
 *
 *  示例 3：
 *
 *
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= nums.length <= 1000
 *  0 <= nums[i] <= 106
 *  1 <= m <= min(50, nums.length)
 *
 *  Related Topics 贪心 数组 二分查找 动态规划
 *  👍 521 👎 0
 */
public class SplitArrayLargestSum {

    @Solution
    public int splitArray(int[] nums, int m) {
        int max = findMax(nums);
        int sum = findSum(nums);
        // 求左边界
        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (split(nums, mid) == m)
                right = mid - 1;
            if (split(nums, mid) > m)
                left = mid + 1;
            if (split(nums, mid) < m)
                right = mid - 1;
        }
        return left;
    }

    // 每个连续子数组和不超过max时，最多可以切分的数组数量 (单调递减)
    private int split(int[] nums, int max) {
        int res = 0;
        int temp = 0;
        int counter = 0; // 表示当前temp > max时，temp是由几个数累加而成的
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            counter++;
            if (temp > max) {
                res++;
                temp = 0;
                if (counter > 1)
                    i--;
                counter = 0;
            }
        }
        if (counter > 0)
            res++;
        return res;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int findSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
