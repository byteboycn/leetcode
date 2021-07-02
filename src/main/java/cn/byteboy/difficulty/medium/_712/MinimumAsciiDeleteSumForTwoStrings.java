package cn.byteboy.difficulty.medium._712;

import cn.byteboy.core.Solution;

import java.util.Arrays;

/**
 * @author hongshaochuan
 * @Date 2021/7/2
 *
 * url: https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/
 *
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 *  示例 1:
 *
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 *
 *
 *  示例 2:
 *
 *
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 *
 *
 *  注意:
 *
 *
 *  0 < s1.length, s2.length <= 1000。
 *  所有字符串中的字符ASCII值在[97, 122]之间。
 *
 *  Related Topics 字符串 动态规划
 *  👍 221 👎 0
 */
public class MinimumAsciiDeleteSumForTwoStrings {


    private String word1;

    private String word2;

    private int[][] memo;

    @Solution
    public int minimumDeleteSum(String s1, String s2) {
        this.word1 = s1;
        this.word2 = s2;
        memo = new int[word1.length()][word2.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(word1.length() - 1, word2.length() - 1);
    }

    private int dp(int x, int y) {
        int res = 0;
        if (x == -1) {
            for (int i = 0; i < y + 1; i++)
                res += word2.charAt(i);
            return res;
        }

        if (y == -1) {
            for (int i = 0; i < x + 1; i++)
                res += word1.charAt(i);
            return res;
        }
        if (memo[x][y] != -1)
            return memo[x][y];
        if (word1.charAt(x) == word2.charAt(y)) {
            memo[x][y] = dp(x - 1, y - 1);
        } else {
            memo[x][y] = Math.min(dp(x - 1, y) + word1.charAt(x), dp(x, y - 1) + word2.charAt(y));
        }
        return memo[x][y];
    }
}
