package cn.byteboy.difficulty.hard._10;

import cn.byteboy.core.Solution;

import javax.annotation.Resource;

/**
 * @author hongshaochuan
 * @Date 2021/7/5
 *
 * url: https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 *
 *  '.' 匹配任意单个字符
 *  '*' 匹配零个或多个前面的那一个元素
 *
 *
 *  所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 *  示例 1：
 *
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 *
 *  示例 2:
 *
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 *
 *  示例 3：
 *
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 *
 *  示例 4：
 *
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 *
 *  示例 5：
 *
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 *
 *
 *  提示：
 *
 *
 *  0 <= s.length <= 20
 *  0 <= p.length <= 30
 *  s 可能为空，且只包含从 a-z 的小写字母。
 *  p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *  保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 *  Related Topics 递归 字符串 动态规划
 *  👍 2216 👎 0
 */
public class RegularExpressionMatching {

    private String s;

    private String p;

    @Solution
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return dp(0, 0);
    }

    private boolean dp(int x, int y) {
        if (y == p.length())
            return x == s.length();
        if (x == s.length()) {
            if ((p.length() - y) % 2 != 0)
                return false;
            for (; y + 1 < p.length(); y+=2) {

                if (p.charAt(y + 1) != '*')
                    return false;
            }
            return true;
        }

        if (s.charAt(x) == p.charAt(y) || p.charAt(y) == '.') {
            if (y < p.length() - 1 && p.charAt(y + 1) == '*') {
                // 匹配0次或多次
                return dp(x, y + 2) || dp(x + 1, y);
            } else {
                // 常规匹配一次
                return dp(x + 1, y + 1);
            }
        } else {
            if (y < p.length() - 1 && p.charAt(y + 1) == '*') {
                // 匹配0次
                return dp(x, y + 2);
            } else {
                return false;
            }
        }

    }


}
