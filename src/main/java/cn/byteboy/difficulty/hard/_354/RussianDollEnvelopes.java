package cn.byteboy.difficulty.hard._354;

import cn.byteboy.core.Solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hongshaochuan
 * @date 2021/6/30
 *
 * url: https://leetcode-cn.com/problems/russian-doll-envelopes/
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 *  当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 *  请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 *  注意：不允许旋转信封。
 *
 *
 *  示例 1：
 *
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 *  示例 2：
 *
 *
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= envelopes.length <= 5000
 *  envelopes[i].length == 2
 *  1 <= wi, hi <= 104
 *
 *  Related Topics 数组 二分查找 动态规划 排序
 *  👍 540 👎 0
 */
public class RussianDollEnvelopes {

    private int[] memo;

    @Solution
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }
        memo = new int[nums.length];
        int res = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res = Math.max(res, dp(nums, i));
        }
        return res;
    }

    private int dp(int[]arr, int x) {
        if (x == 0)
            return 1;
        if (memo[x] != 0)
            return memo[x];

        int res = 1;
        for (int i = x - 1; i >= 0; i--) {
            if (arr[x] > arr[i]) {
                res = Math.max(res, dp(arr, i) + 1);
            }
        }
        memo[x] = res;
        return res;
    }
}
