package cn.byteboy.difficulty.medium._416;

import cn.byteboy.core.Solution;

import java.util.Arrays;

/**
 * @author hongshaochuan
 * @Date 2021/7/2
 *
 * url: https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 *  示例 2：
 *
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= nums.length <= 200
 *  1 <= nums[i] <= 100
 *
 *  Related Topics 数组 动态规划
 *  👍 848 👎 0
 */
public class PartitionEqualSubsetSum {

    // 0:未初始化 1：true 2：false
    private boolean[] memo;

    @Solution
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int half  = sum / 2;

        memo = new boolean[half + 1];
        Arrays.fill(memo, false);
        memo[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= 0; j--)
                if (j >= nums[i])
                    memo[j] = memo[j] || memo[j - nums[i]];
        }

        return memo[half];

//        return dp(nums, nums.length - 1, half);
//
    }

    // dp(nums, x, y)表示nums[0, x]是否子集合的和等于y
    private boolean dp(int[] nums, int x, int y) {
        if (x == -1)
            return false;
        if (y == 0)
            return true;

        return dp(nums, x - 1, y - nums[x]) || dp(nums, x - 1, y) ;

//        if (nums[x] > y) {
//            // 装不下，不装了
//            return dp(nums, x - 1, y);
//        } else {
//            // 装的下，装或者不装
//            return dp(nums, x - 1, y - nums[x]) || dp(nums, x - 1, y) ;
//        }
    }

}
