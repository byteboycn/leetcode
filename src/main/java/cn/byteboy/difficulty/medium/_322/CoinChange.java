package cn.byteboy.difficulty.medium._322;

import cn.byteboy.core.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hongshaochuan
 * @date 2021/6/26
 *
 * https://leetcode-cn.com/problems/coin-change/
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
 *  -1。
 *
 *  你可以认为每种硬币的数量是无限的。
 *
 *  示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 *  示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 *  示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 *  示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 *  示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 *  提示：
 *  1 <= coins.length <= 12
 *  1 <= coins[i] <= 231 - 1
 *  0 <= amount <= 104
 *
 *  Related Topics 广度优先搜索 数组 动态规划
 *  👍 1341 👎 0
 */
public class CoinChange {

    // key -> value : amount -> min coin count
    private Map<Integer, Integer> dp = new HashMap<>();

    @Solution
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        Integer r = dp.get(amount);
        if (r != null)
            return r;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int i = coinChange(coins, amount - coin);
            if (i == -1)
                continue;
            res = Math.min(res, i + 1);
        }
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        dp.put(amount, res);
        return res;
    }



}
