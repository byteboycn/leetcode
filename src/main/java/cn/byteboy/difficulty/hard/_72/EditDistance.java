package cn.byteboy.difficulty.hard._72;

import cn.byteboy.core.Solution;

import java.util.Arrays;

/**
 * @author hongshaochuan
 * @date 2021/6/30
 *
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 *  你可以对一个单词进行如下三种操作：
 *
 *
 *  插入一个字符
 *  删除一个字符
 *  替换一个字符
 *
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 *
 *  示例 2：
 *
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 *
 *
 *
 *  提示：
 *
 *
 *  0 <= word1.length, word2.length <= 500
 *  word1 和 word2 由小写英文字母组成
 *
 *  Related Topics 字符串 动态规划
 *  👍 1670 👎 0
 */
public class EditDistance {

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

    // word1[0, x] 和 word2[0, y]的最小编辑距离
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
            memo[x][y] = min(
                dp(x, y - 1) + 1,
                dp(x - 1, y) + 1,
                dp(x - 1, y - 1) + 1
            );
        return memo[x][y];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
