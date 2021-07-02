package cn.byteboy.difficulty.medium._516;

import cn.byteboy.core.Solution;

import java.util.Arrays;

/**
 * @author hongshaochuan
 * @Date 2021/7/2
 *
 * url: https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。

 *  示例 1:
 * 输入:
 *
 *  "bbbab"
 *
 *
 *  输出:
 *
 *  4
 *
 *
 *  一个可能的最长回文子序列为 "bbbb"。
 *
 *  示例 2:
 * 输入:
 *
 *  "cbbd"
 *
 *
 *  输出:
 *
 *  2
 *
 *
 *  一个可能的最长回文子序列为 "bb"。
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= s.length <= 1000
 *  s 只包含小写英文字母
 *
 *  Related Topics 字符串 动态规划
 *  👍 465 👎 0
 */
public class LongestPalindromicSubsequence {

    private String s;

    private int[][]memo;

    @Solution
    public int longestPalindromeSubseq(String s) {
        this.s = s;
        memo = new int[s.length()][s.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(0, s.length() - 1);
    }

    private int dp(int x, int y) {
        if (y < x)
            return 0;
        if (x == y)
            return 1;
        if (memo[x][y] != -1)
            return memo[x][y];
        if (s.charAt(x) == s.charAt(y))
            memo[x][y] = dp(x + 1, y - 1) + 2;
        else
            memo[x][y] =  Math.max(dp(x + 1, y), dp(x , y - 1));
        return memo[x][y];
    }

}
