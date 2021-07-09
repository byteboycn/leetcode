package cn.byteboy.difficulty.easy._28;

import cn.byteboy.core.Solution;

/**
 * @author hongshaochuan
 * @Date 2021/7/7
 *
 * 实现 strStr() 函数。
 *
 *  给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
 * 果不存在，则返回 -1 。
 *
 *
 *
 *  说明：
 *
 *  当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 *  对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 *
 *  示例 2：
 *
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 *
 *  示例 3：
 *
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 *
 *
 *
 *  提示：
 *
 *
 *  0 <= haystack.length, needle.length <= 5 * 104
 *  haystack 和 needle 仅由小写英文字符组成
 *
 *  Related Topics 双指针 字符串 字符串匹配
 *  👍 954 👎 0
 */
public class ImplementStrstr {

    private String txt;

    private String pat;

    private int[][] dp;

    @Solution
    public int strStr(String haystack, String needle) {
        this.txt = haystack;
        this.pat = needle;

        if ("".equals(this.pat) && "".equals(this.txt))
            return 0;
        if ("".equals(this.pat))
            return 0;

        initKMP();
        return search();
    }

    // 确定有限状态机
    private void initKMP() {
        dp = new int[pat.length()][256];
        dp[0][pat.charAt(0)] = 1;

        int x = 0;
        for (int i = 1; i < pat.length(); i++) {
            for (int j = 0; j < 256; j++)
                dp[i][j] = dp[x][j];
            dp[i][pat.charAt(i)] = i + 1;
            x = dp[x][pat.charAt(i)];
        }
    }

    private int search() {

        int j = 0;
        for (int i = 0; i < txt.length(); i++) {
            j = dp[j][txt.charAt(i)];
            if (j == pat.length())
                return i - pat.length() + 1;
        }
        return -1;
    }
}
