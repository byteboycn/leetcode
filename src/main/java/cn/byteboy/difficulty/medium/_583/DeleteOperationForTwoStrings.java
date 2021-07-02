package cn.byteboy.difficulty.medium._583;

import cn.byteboy.core.Solution;

import java.util.Arrays;

/**
 * @author hongshaochuan
 * @Date 2021/7/2
 *
 * url: https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 *
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 *
 *
 *  示例：
 *
 *  输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 *
 *
 *
 *  提示：
 *
 *
 *  给定单词的长度不超过500。
 *  给定单词中的字符只含有小写字母。
 *
 *  Related Topics 字符串 动态规划
 *  👍 204 👎 0
 */
public class DeleteOperationForTwoStrings {

    private String word1;

    private String word2;

    private int[][] memo;

    @Solution
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        memo = new int[word1.length()][word2.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(word1.length() - 1, word2.length() - 1);
    }

    private int dp(int x, int y) {
        if (x == -1)
            return y + 1;
        if (y == -1)
            return x + 1;
        if (memo[x][y] != -1)
            return memo[x][y];
        if (word1.charAt(x) == word2.charAt(y))
            memo[x][y] = dp(x - 1, y - 1);
        else
            memo[x][y] = Math.min(dp(x - 1, y) +1, dp(x, y - 1) + 1);
        return memo[x][y];
    }
}
