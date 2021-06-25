package cn.byteboy.difficulty.medium;

/**
 * @author Nature
 * @version 1.0
 * @email xhhsc@outlook.com
 * @date 2020/2/10 2:53 AM
 *
 * @name
 * 最长回文子串
 *
 * @description
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * @example
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome1("bab"));
    }

    /** 中心扩展法 */
    public String longestPalindrome1(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = center(s, i, i);
            int len2 = center(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                if (len1 > len2) {
                    start = i - (len1 - 1) / 2;
                } else {
                    start = (i - len2 / 2) + 1;
                }
                end = start + len;
            }
        }

        return s.substring(start, end);
    }

    // 计算回文长度
    private int center(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    /**    暴力法 时间复杂度是 O(n^3)  空间复杂度：O(1)     */
    public String longestPalindrome(String s) {

        if (s.length() == 1 || s.equals(""))
            return s;
        String maxString = "";
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                if (isVaild(s.substring(j, j + i))) {
                    maxString = s.substring(j, j + i);
                    break;
                }
            }
        }
        return maxString;
    }

    // 验证是否是回文字符串
    private boolean isVaild(String s) {
        if (s.length() == 1 || s.equals(""))
            return true;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] != c[c.length - i - 1])
                return false;
        }
        return true;
    }
}
