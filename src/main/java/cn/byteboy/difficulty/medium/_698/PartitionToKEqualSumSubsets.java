package cn.byteboy.difficulty.medium._698;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @date 2021/8/10
 *
 * 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 *  示例 1：
 *
 *  输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= k <= len(nums) <= 16
 *  0 < nums[i] < 10000
 *
 *  Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩
 *  👍 391 👎 0
 */
public class PartitionToKEqualSumSubsets {


    @Solution
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        if (k > len) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;

        int target = sum / k;
        int[] buckets = new int[k];
        return backtrack(nums, 0, buckets, target);
    }

    private boolean backtrack(int[] nums, int index, int[] buckets, int target) {
        if (index == nums.length) {
            for (int bucket : buckets) {
                if (bucket != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[index] > target) {
                continue;
            }
            buckets[i] += nums[index];

            if (backtrack(nums, index + 1, buckets, target)) {
                return true;
            }

            buckets[i] -= nums[index];
        }

        return false;
    }


    @Solution
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int len = nums.length;
        if (k > len) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;

        int target = sum / k;
        int[] buckets = new int[k];
        boolean[] used = new boolean[len];

        return backtrack2(nums, used, 0, 0, k, target);
    }

    private boolean backtrack2(int[] nums, boolean[] used, int bucket, int start, int k, int target) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            return backtrack2(nums, used, 0, 0, k - 1, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (bucket + nums[i] > target) {
                continue;
            }
            used[i] = true;
            // 对于同一个桶，不需要每次都重新遍历整个nums，从start的下一个开始遍历
            if (backtrack2(nums, used, bucket + nums[i], start + 1, k, target)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }


}
